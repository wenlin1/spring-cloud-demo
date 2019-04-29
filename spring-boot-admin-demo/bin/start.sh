#!/bin/sh

SERVER_PORT=8099
SERVER_NAME=spring-admin-2.0-SNAPSHOT.jar
JAVA_HOME="/usr/java/jdk1.8.0_144/bin"

cd `dirname $0`
SERVER_DIR=`pwd`
CONF_DIR=$SERVER_DIR/config
LOG_DIR=$SERVER_DIR/logs

echo "server dir is $SERVER_DIR"

JAVA_OPTS="-server"

#memory
JAVA_OPTS="$JAVA_OPTS -Xmx4g -Xms4g -Xss256k -XX:MaxDirectMemorySize=1G"

#gc
JAVA_OPTS="$JAVA_OPTS -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -XX:G1ReservePercent=25 -XX:InitiatingHeapOccupancyPercent=40 -XX:+PrintGCDateStamps -Xloggc:$LOG_DIR/gc.log -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$LOG_DIR/java.hprof -XX:+DisableExplicitGC -XX:-OmitStackTraceInFastThrow -XX:+PrintCommandLineFlags -XX:+UnlockCommercialFeatures -XX:+FlightRecorder"

#param
JAVA_OPTS="$JAVA_OPTS -Djava.awt.headless=true -Djava.net.preferIPv4Stack=true -Djava.util.Arrays.useLegacyMergeSort=true -Dfile.encoding=UTF-8"

#pinpoint agent
#JAVA_OPTS="$JAVA_OPTS -javaagent:/opt/springcloud/pinpoint-agent-1.6.2/pinpoint-bootstrap-1.6.2.jar -Dpinpoint.agentId=account-server3 -Dpinpoint.applicationName=account-server"

if [ ! -e "$SERVER_DIR/$SERVER_NAME" ]; then
    echo "ERROR: the $SERVER_NAME does not exists!"
    exit 1
fi

if [ ! -d "$LOG_DIR" ]; then
    echo 'log dir is not exists'
    mkdir -p "$LOG_DIR"
fi

PIDS=`ps -f | grep java | grep "${SERVER_NAME}" |awk '{print $2}'`
if [ -n "$PIDS" ]; then
    echo "ERROR: The ${SERVER_NAME} already started!"
    echo "PID: $PIDS"
    exit 1
fi

echo -e "Starting the ${SERVER_NAME} ...\c"

echo "JAVA_OPTS=$JAVA_OPTS"

STDOUT_FILE=$LOG_DIR/stdout.log

nohup $JAVA_HOME/java $JAVA_OPTS -jar $SERVER_DIR/$SERVER_NAME --server.port=$SERVER_PORT --spring.config.location=$CONF_DIR > $STDOUT_FILE 2>&1 &

COUNT=0
while [ $COUNT -lt 1 ]; do
    #echo -e ".\c"
    sleep 1
    COUNT=`ps -f | grep java | grep "$SERVER_DIR/$SERVER_NAME" | awk '{print $2}' | wc -l`
    if [ $COUNT -gt 0 ]; then
        break
    fi
done

echo "start ${SERVER_NAME} OK!"
PIDS=`ps -f | grep java | grep "$SERVER_DIR/$SERVER_NAME" | awk '{print $2}'`
echo "PID: $PIDS"
echo "STDOUT: $STDOUT_FILE"