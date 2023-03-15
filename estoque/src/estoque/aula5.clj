(ns estoque.aula5)

(def estoque {"Mochila" 10 "Camiseta" 5})

(println estoque)
(println "A contagem é:" (count estoque))
(println "As chaves são:" (keys estoque))


(def estoque {:mochila 10 :camiseta 5})
(assoc estoque :cadeira 3)


(def pedido {
             :mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}})

(def pedido (assoc pedido :chaveiro {:quantidade 1, :preco 10}))

(println pedido)
