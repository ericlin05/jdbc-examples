rm -fr jars
mkdir jars 
cd jars

mkdir HiveJDBC4
cd HiveJDBC4

echo "Downloading Hive JDBC Driver"
version=2.5.4.1006
target=Cloudera_HiveJDBC_${version}.zip
wget https://downloads.cloudera.com/connectors/$target
unzip $target
unzip Cloudera_HiveJDBC4_${version}.zip

echo "Downloading Impala JDBC Driver"
cd ..
version=2.5.16.1018
target=impala_jdbc_${version}.zip
wget http://downloads.cloudera.com/connectors/$target
unzip $target
unzip $version/Cloudera_ImpalaJDBC41_${version}.zip

rm -f HiveJDBC4/*.zip
rm -f *.zip
rm -fr $version
rm -f ImpalaJDBC41//*.zip
