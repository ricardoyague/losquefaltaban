# losquefaltaban

* Install Java 17

https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/amazon-linux-install.html

* Install mysql and configure user

https://tecadmin.net/how-to-install-mysql-8-on-amazon-linux-2/

mysql> CREATE USER 'lqf_user'@'%' IDENTIFIED BY '$L0squ3f4lt4b4n$';
Query OK, 0 rows affected (0.00 sec)

mysql> GRANT ALL PRIVILEGES ON *.* TO 'lqf_user'@'%' WITH GRANT OPTION;
Query OK, 0 rows affected (0.00 sec)

* Install certificate

sudo pip3 install certbot certbot-nginx

* Install as a service

https://computingforgeeks.com/how-to-run-java-jar-application-with-systemd-on-linux/?utm_content=cmp-true