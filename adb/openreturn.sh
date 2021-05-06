for (( i=1;i<=300;i++ ))
do
    echo "第 $i 次 >>>>"
    adb shell am start -a android.intent.action.VIEW -d  http://www.google.cn/
    sleep 1
    adb shell input keyevent 4
    sleep 1
done