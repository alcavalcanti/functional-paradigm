(ns loja.aula2)

;["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]

(defn conta
      ([elementos] (conta 0 elementos))
      ([total-ate-agora elementos]
       ;(println total-ate-agora elementos)
       (if (seq elementos)
         (recur (inc total-ate-agora) (next elementos))
         total-ate-agora)))

(println (conta ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println (conta []))

(defn minha-funcao
      ([parametro1] (println "p1" parametro1))
      ([parametro1 parametro2] (println "p2" parametro1 parametro2))
      )

(minha-funcao 1)
(minha-funcao 1 2)


(defn nova-contagem
      [elementos]
      (loop [total-ate-agora 0
             elementos-restantes
             elementos]
        (if (seq elementos-restantes)
          (recur (inc total-ate-agora) (next elementos-restantes))
          total-ate-agora)))

(println "nova contagem com elementos" (nova-contagem ["daniela" "guilherme" "carlos" "paulo" "lucia" "ana"]))
(println "nova contagem sem elementos" (nova-contagem []))
