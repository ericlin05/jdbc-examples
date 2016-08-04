version=2.5.4.1006
target=Cloudera_HiveJDBC_${version}.zip
mkdir jars 
cd jars
wget https://downloads.cloudera.com/connectors/$target
unzip $target
unzip Cloudera_HiveJDBC4_${version}.zip
rm *.zip
