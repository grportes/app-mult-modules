#!/bin/bash

fnCriarBaseSqlLite()
{
  echo "Criando base sqllite...."
  if [ -d /tmp/play ]; then
    rm -rf /tmp/play
  fi
  mkdir /tmp/play
  sqlite3 /tmp/play/exemplo.db <<EOF
  create table usuarios (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    nome VARCHAR(100) NOT NULL,
    version INTEGER NOT NULL
  );
  insert into usuarios( nome, version ) values ( "ABC", 0 );
  insert into usuarios( nome, version ) values ( "XXX", 0 );
EOF
  echo "base criada!!"
}

fnRemoverTarget()
{
    echo "$1"
    rm -rf modules/$1/target
}


x="teste"
fn_menu ()
{
	while true $x != "teste"
	do
		clear
		echo "1) Console"
		echo ""
		echo "2) Servidor modo debug - porta:9998 "
		echo ""
		echo "3) Limpar projeto"
		echo ""
		echo "4) Criar base sqlLite"
		echo ""
		echo "7) Sair do programa"
		echo ""
		echo "================================================"

		read -p "Informe a opção desejada:" x

		case "$x" in
			1)
				sh sbt -J-XX:MaxMetaspaceSize=500m
                exit
				;;
			2)
				sh sbt -J-XX:MaxMetaspaceSize=500m -jvm-debug 9998 run
                exit
				;;
			3)
				echo "Principal"
				rm -rf target

                fnRemoverTarget "admin"
                fnRemoverTarget "commons"
                fnRemoverTarget "repository"
                fnRemoverTarget "transporte"
				sleep 3
				;;
			4)
				fnCriarBaseSqlLite
				sleep 3
                ;;
			7)
				exit;
				;;
			*)
				echo "Opção inválida!"
		esac
	done
}

fn_menu
