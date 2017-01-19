# WaveTest

[**Video**](/screencast.gif)

![Screenshot](/screenshot.png?raw=true)

## Building and running
```
echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list
sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 642AC823
sudo apt-get update
sudo apt-get install default-jdk scala sbt
sbt run
```
