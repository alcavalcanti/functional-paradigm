(ns estoque.aula3)

(defn valor-descontado
      "Retorna o valor com desconto de 10% se deve aplicar desconto"
      [aplica? valor-bruto]
      (if (aplica? valor-bruto)
        (let [taxa-de-desconto (/ 10 100)
              desconto (* valor-bruto taxa-de-desconto)]
          (- valor-bruto desconto))
        valor-bruto))

;PREDICATE
(defn aplica-desconto?
      [valor-bruto]
      (> valor-bruto 100))

(println (valor-descontado aplica-desconto? 1000))
(println (valor-descontado aplica-desconto? 100))
(println (aplica-desconto? 1000))
(println (aplica-desconto? 100))