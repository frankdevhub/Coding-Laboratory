set ignorecase
set cursorline
set autoindent

autocmd BufNewFile *.sh exec":call SetTitle()"

func SetTitle()
if expand("%:e") == 'sh'
         call setline(1,"#!/bin/bash")
         call setline(2,"#")
         call setline(3,"#********************************************************************")
         call setline(4,"#Author:               frankdevhub@gmail.com")
         call setline(5,"#Date：                ".strftime("%Y-%m-%d"))
         call setline(6,"#FileName：            ".expand("%"))
         call setline(7,"#URL：                 https://www.frankdevhub.site")
         call setline(8,"#Description：         TODO")
         call setline(9,"#Copyright (C)：      ".strftime("%Y")." All rights reserved")
         call setline(10,"#********************************************************************")
         call setline(11,"#")
         call setline(12,"")
endif
endfunc

autocmd BufNewFile * normal G




