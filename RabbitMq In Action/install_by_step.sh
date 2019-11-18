##下载地址
wget  http://www.rabbitmq.com/releases/erlang/erlang-19.0-1.el6.x86_64.rpm
##下载之后， rpm -Uvh erlang-19.0-1.el6.x86_64.rpm   安装即可


##下载地址
wget http://www.rabbitmq.com/releases/rabbitmq-server/v3.6.14/rabbitmq-server-3.6.14-1.el6.noarch.rpm
##下载之后，rpm -Uvh rabbitmq-server-3.6.14-1.el6.noarch.rpm   安装即可。
##可能缺少依赖包，缺什么yum装什么就好。
##缺了一个yum -y install socat* 安装即可


#查看rabbitmq是否安装成功

##软件是否安装成功：
rpm -qa | grep rabbitmq

##启动命令
service rabbitmq-server start

##停止命令
service rabbitmq-server stop

##查看状态
rabbitmqctl status
			 
			 

##安装命令维护插件（epel的源）			 
rabbitmq-plugins enable rabbitmq_management

##设置配置文件，并开启用户远程访问

cd /etc/rabbitmq/

cp /usr/share/doc/rabbitmq-server-3.6.14/rabbitmq.config.example /etc/rabbitmq/

mv rabbitmq.config.example  rabbitmq.config

vim /etc/rabbitmq/rabbitmq.config
##修改前：%%{loopback_users, []}，

##修改后：{loopback_users, []}


##重启服务，IP+15672端口访问

service rabbitmq-server restart


##防火墙
firewall-cmd --zone=public --add-port=15672/tcp --permanent

firewall-cmd --zone=public --add-port=5672/tcp --permanent

firewall-cmd --reload


##创建账户
rabbitmqctl add_user test 123456

##设置用户角色
rabbitmqctl  set_user_tags  test  administrator

##设置用户权限
rabbitmqctl set_permissions -p "/" test ".*" ".*" ".*"

##设置完成后可以查看当前用户和角色(需要开启服务)
rabbitmqctl list_users