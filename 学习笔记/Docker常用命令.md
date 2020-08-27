## Docker命令

systemctl stop firewalld.service  关闭防火墙

docker inspect 容器id  查询容器信息

docker stop 容器id  停止容器id

docker rm 容器id  删除容器id

systemctl restart  docker  重启docker容器

docker exec -it 容器ID /bin/bash 进入容器 

docker rm $(sudo docker ps -a -q) 删除所有未运行的容器

docker search elasticsearch 搜索镜像文件 

docker run 创建并启动一个容器，在run后面加上-d参数，则会创建一个守护式容器在后台运行。

docker ps -a 查看已经创建的容器

docker ps -s 查看已经启动的容器

docker start con_name 启动容器名为con_name的容器

docker stop con_name 停止容器名为con_name的容器

docker rm con_name 删除容器名为con_name的容器

docker rename old_name new_name 重命名一个容器

docker attach con_name 将终端附着到正在运行的容器名为con_name的容器的终端上面去，前提是创建该容器时指定了

相应的sh

docker logs --tail="10" 容器名称   查询容器日志信息



1.停止所有的container，这样才能够删除其中的images：

docker stop $(docker ps -a -q)
如果想要删除所有container的话再加一个指令：
docker rm $(docker ps -a -q)

2.查看当前有些什么images

docker images

3.删除images，通过image的id来指定删除谁

docker rmi <image id>

想要删除untagged images，也就是那些id为<None>的image的话可以用

docker rmi $(docker images | grep "^<none>" | awk "{print $3}")
要删除全部image的话
docker rmi $(docker images -q)

firewalld的基本使用

启动： systemctl start firewalld

关闭： systemctl stop firewalld

查看状态： systemctl status firewalld 

开机禁用  ： systemctl disable firewalld

开机启用  ： systemctl enable firewalld

添加

firewall-cmd --zone=public --add-port=80/tcp --permanent    （--permanent永久生效，没有此参数重启后失效）

重新载入

firewall-cmd --reload

查看

firewall-cmd --zone= public --query-port=80/tcp

删除

firewall-cmd --zone= public --remove-port=80/tcp --permanent