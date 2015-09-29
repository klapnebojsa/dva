(ns dva.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, Klap!")
)

(defn kk
  "Bez argumenta ili sa gomilom argumenata"
  [& args]
  (if (not= nil args) (foo args) (foo "nista je"))
)

(def mult
  "rekurzija"  
  (fn this
      ([] 1)
      ([x] x)
      ([x y] (* x y))
      ([x y & more](apply this (this x y) more)))
)
(defn fact[x]
  (with-local-vars [acc 1, cnt x]
   (while (> @cnt 0)
     (var-set acc (* @acc @cnt))
     (var-set cnt (dec @cnt)))      ;; dec - decrease (umanji vrednost var-get cnt za jedan)
    @acc))

(defn kk1
  "Bez argumenta ili sa gomilom argumenata"
  [& args] 
  (with-local-vars [a args]
    (if (nil? args) 
      (do                                  ;;kada ima vise komandi za true u if 
        (var-set a "nista je")
        (println "aa"))
      (var-set a args))    
    (println args "xxx Hello, Klap!")  
    (println @a "Hello, Klap!")))           ;;@a je ekvivalentno sa (var-get a)        

(defn kk2 [args] 
  (with-local-vars [a args]
    (if (nil? args) 
      (var-set a "nista je")
      (var-set a (dec @a)))
    (println args "xxx Hello, Klap!")  
    (println @a "Hello, Klap!")))           ;;@a je ekvivalentno sa (var-get a) 



