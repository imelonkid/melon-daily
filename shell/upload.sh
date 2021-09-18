PROJECT_PATCH=$(dirname $(pwd))
PROGRAM_NAME="melon-daily"

jar(){
  scp $PROJECT_PATCH/melon-daily-starter/target/$PROGRAM_NAME.jar melonkid@49.232.131.132:~/workspace
}

shell(){
  scp $PROJECT_PATCH/shell/bootstrap.sh melonkid@49.232.131.132:~/workspace
}

ngconf(){
  scp $PROJECT_PATCH/conf/nginx.conf melonkid@49.232.131.132:~/workspace
}

db(){
    scp -r $PROJECT_PATCH/$PROGRAM_NAME.db melonkid@49.232.131.132:~/workspace/datas
}

user_exists(){
  if id -u $1 >/dev/null 2>&1; then
    echo "1"
  else
    echo "0"
  fi
}

case $1 in
        jar)
          jar
        ;;

        shell)
          shell
        ;;

        ngconf)
          ngconf
        ;;

        db)
          db
        ;;
        *)
      echo -e $USAGE
        ;;
esac
exit 0