(ns estoque.aula4)

(def precos [30 700 1000])

(defn aplica-desconto?
      [valor-bruto]
      (> valor-bruto 100))

(defn valor-descontado
      "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
      [valor-bruto]
      (if (aplica-desconto? valor-bruto)
        (let [taxa-de-desconto (/ 10 100)
              desconto         (* valor-bruto taxa-de-desconto)]
          (- valor-bruto desconto))
        valor-bruto))

(println (map valor-descontado precos))
(println "filter" (filter aplica-desconto? precos))

(println (reduce + precos))