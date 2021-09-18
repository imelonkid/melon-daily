## 更新配置文件
1. 修改完配置文件后，使用upload.sh脚本进行上传
2. 手动备飞服务器上的老版本配置
```shell
    sudo mv /usr/local/nginx/conf/nginx.conf /usr/local/nginx/conf/nginx.conf_bak 
```

4. 手动杀死nginx服务，注意要杀死两个进程
5. 手动重启服务
```shell
    sudo /usr/local/nginx/sbin/nginx
```
