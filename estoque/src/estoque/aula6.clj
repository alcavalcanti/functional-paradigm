(ns estoque.aula6)

(def pedido {
             :mochila  {:quantidade 2, :preco 80}
             :camiseta {:quantidade 3, :preco 40}
             :chaveiro {:quantidade 1, :preco 0}})

(defn imprime-e-15 [[chave valor]]
      (println "chave" chave "e valor" valor) 15)

(println (map imprime-e-15 pedido))

(defn preco-dos-produtos [[_ valor]]
      (* (:quantidade valor) (:preco valor)))

(println (map preco-dos-produtos pedido))

(defn total-pedido
      [pedido]
      (->> pedido
           (map preco-dos-produtos)
           (reduce +))
      ;(reduce + (map preco-dos-produtos pedido))
      )
(println (total-pedido pedido))

(defn preco-total-do-produto [produto]
      (* (:quantidade produto) (:preco produto)))

(defn total-pedido
      [pedido]
      (->> pedido
           vals
           (map preco-total-do-produto)
           (reduce +)))

(println (total-pedido pedido))

(defn gratuito?
      [item]
      (<= (get item :preco 0) 0))
(println "Filtrando gratuitos" (filter gratuito? (vals pedido)))

;DESTRUCT
(defn gratuito?
      [[_ item]]
      (<= (get item :preco 0) 0))
(println "Filtrando gratuitos" (filter gratuito? pedido))

;LAMBDA
(defn gratuito?
      [item]
      (<= (get item :preco 0) 0))
(println "Filtrando gratuitos" (filter (fn [[chave item]] (gratuito? item)) pedido))
(println "Filtrando gratuitos" (filter #(gratuito? (second %)) pedido))


(defn pago?
      [item]
      (not (gratuito? item)))

(println "Filtrando pagos" (pago? {:preco 50}))
(println "Filtrando pagos" (pago? {:preco 0}))

(println ((comp not gratuito?) {:preco 50}))

(def pago? (comp not gratuito?))

(println (pago? {:preco 50}))