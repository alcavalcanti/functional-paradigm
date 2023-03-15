(ns loja.aula1)
;["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]
;{"guilherme" 37, "paulo" 39}
;'(1 2 3 4 5 6)
;[[0 1]]
; #{}

;map
;reduce
;filter

(map println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(println (first ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (rest ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (next ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (seq [1 2 3 4 5]))


(defn meu-mapa [funcao sequencia]
      (let [primeiro (first sequencia)]
        (if primeiro
          (do (funcao primeiro)
              (meu-mapa funcao (rest sequencia))))))

(println "MEU MAPA STOP FALSE")
(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"])


(defn meu-mapa [funcao sequencia]
      (let [primeiro (first sequencia)]
        (if (not (nil? primeiro))
          (do (funcao primeiro)
              (meu-mapa funcao (rest sequencia))))))

(println "MEU MAPA STOP NIL")
(meu-mapa println ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"])
(meu-mapa println ["daniela" false "carlos" "paulo" "lucia" "ana"])


(defn meu-mapa [funcao sequencia]
      (let [primeiro (first sequencia)]
        (if (not (nil? primeiro))
          (do (funcao primeiro)
              (recur funcao (rest sequencia))))))
;RECURSIVIDADE (LEMBRANDO QUE NECESSÁRIAMENTE PRECISA SER TAIL POSITION)

(meu-mapa println (range 5000))
