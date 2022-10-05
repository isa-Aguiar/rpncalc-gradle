#! /bin/bash

cp ../app/build/libs/app.jar ./app.jar

falhou=0
for entrada in *_entrada.txt; do
  teste=$(echo ${entrada} | sed -e s/_entrada.txt//)
  saida_esperada="${teste}_saida.txt"
  linhas=$(wc -l ${saida_esperada} | cut -f 1 -d " ")
  echo -n "Rodando o teste de aceitação ${teste}.........."
  java -jar app.jar < ${entrada} | tail -n ${linhas} -- > saida_atual.txt
  diff -q --strip-trailing-cr ${saida_esperada} saida_atual.txt > diferenca.txt
  cat diferenca.txt
  if [ $? -ne 0 ]; then
    falhou=1
    echo "FALHOU"
    echo "Erro no teste ${teste}:"
    echo ">>>>>> ESPERADO"
    cat ${saida_esperada}
    echo "======"
    cat saida_atual.txt
    echo "<<<<<< OBTIDO"
  else
    echo "PASSOU"
  fi
done

rm saida_atual.txt diferenca.txt

exit ${falhou}
