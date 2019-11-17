#!/bin/bash
#
#********************************************************************
#Author:               frankdevhub@gmail.com
#Date：                2019-11-17
#FileName：            pwgen-filename-test.sh
#URL：                 https://www.frankdevhub.site
#Description：         批量生成随机字符文件名案例
#                      使用for循环在/clsn目录下批量创建10个html文件，
#                      其中每个文件需要包含10个随机小写字母加固定字符串clsn
#Copyright (C)：      2019 All rights reserved
#********************************************************************
#



[ -d /clsn ] || mkdir -p /clsn
 rpm -qa |grep pwgen &>/dev/null
 if [ $? -eq  1 ] 
   then   yum install pwgen -y &>/dev/null
 fi
 
 cd /clsn &&\
 for i in {1..10}
   do
    #File_Name=`uuidgen |tr "0-9-" "a-z"|cut -c 1-10`
    File_Name2=`pwgen -1A0 10`
    touch ${File_Name2}_clsn.html
 done
