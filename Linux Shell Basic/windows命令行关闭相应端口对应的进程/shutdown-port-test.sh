#!/bin/bash
#
#********************************************************************
#Author:               frankdevhub@gmail.com
#Date：                2019-11-17
#FileName：            shutdown-port-test.sh
#URL：                 https://www.frankdevhub.site
#Description：         关闭相应的端口号对应的进程
#Copyright (C)：      2019 All rights reserved
#********************************************************************
#


@ECHO OFF
SETLOCAL ENABLEDDELAYEDEXPANSION

@echo "start"

for /f "tokens=5" %%i in ('netstat -aon ^|grep "4000"') do(
   set n=%%i
)

if not "%n%"=="" do(
  taskkill /f /pid %n%
)

PAUSE



