(ns loja.aula3
  (:require [loja.db :as l.db]))

(println "Todos os pedidos:" (l.db/todos-os-pedidos))
(println "Todos os pedidos, agrupados por usuário"
         (group-by :usuario (l.db/todos-os-pedidos)))

(defn minha-funcao-de-agrupamento
      [elemento]
      (println "elemento" elemento)
      (:usuario elemento))

(println "Todos os pedidos, minha função de agrupamento"
         (group-by minha-funcao-de-agrupamento (l.db/todos-os-pedidos)))

(println (map count (vals (group-by :usuario (l.db/todos-os-pedidos)))))

(defn total-do-item
      [[_ detalhes]]
      (* (get detalhes :quantidade 0) (get detalhes :preco-unitario 0)))

(defn total-do-pedido
      [pedido]
      (->> pedido
           (map total-do-item)
           (reduce +)))

(defn total-dos-pedidos
      [pedidos]
      (->> pedidos
           (map :itens)
           (map total-do-pedido)
           (reduce +)))

(defn total-de-pedidos-e-valor-da-compra-por-usuario
      [[usuario pedidos]]
      {:usuario-id       usuario
       :total-de-pedidos (count pedidos)
       :preco-total      (total-dos-pedidos pedidos)})

(->> (l.db/todos-os-pedidos)
     (group-by :usuario)
     (map total-de-pedidos-e-valor-da-compra-por-usuario)
     println)