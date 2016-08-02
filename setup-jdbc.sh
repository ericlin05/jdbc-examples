version=2.5.4.1006
target=Cloudera_HiveJDBC_${version}.zip
wget https://downloads.cloudera.com/connectors/$target
unzip $target
mkdir Cloudera_HiveJDBC4_${version};
cd Cloudera_HiveJDBC4_${version}
unzip ../Cloudera_HiveJDBC4_${version}.zip
export CLASSPATH=$CLASSPATH:`pwd`/Cloudera_HiveJDBC4_${version}/*:`hadoop classpath`:/opt/cloudera/parcels/CDH-*/lib/hive/lib

