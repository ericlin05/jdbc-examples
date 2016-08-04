version=2.5.4.1006
target=Cloudera_HiveJDBC_${version}.zip
wget https://downloads.cloudera.com/connectors/$target
unzip $target
mkdir jars 
cd jars
unzip ../Cloudera_HiveJDBC4_${version}.zip

