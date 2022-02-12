#!/usr/local/bin/clojure

;TOL IS NOT RECEIVING AN ARGUMENT THUS DIVIDING BY ZERO
    ;user=> (vdiv 4 550 600 7)
    ; 48
    ; user=> (vdiv 5 50 50 5)
    ; Execution error (ArithmeticException) at user/vdiv (REPL:5).
    ; Divide by zero

    ; user=> (- tol)
    ; Execution error (ClassCastException) at user/eval300 (REPL:1).
    ; class user$vdiv$tol__293 cannot be cast to class java.lang.Number (user$vdiv$tol__293 is in unnamed module of loader clojure.lang.DynamicClassLoader @543e593; java.lang.Number is in module java.base of loader 'bootstrap')
    ; user=> (* tol -1)
    ; Execution error (ClassCastException) at user/eval302 (REPL:1).
    ; class user$vdiv$tol__293 cannot be cast to class java.lang.Number (user$vdiv$tol__293 is in unnamed module of loader clojure.lang.DynamicClassLoader @543e593; java.lang.Number is in module java.base of loader 'bootstrap')

    ; user=> (tol 1)
    ; 1/100
    ; user=> (tol -1)
    ; -1/100

    ; user=> (* 5 (- tol))
    ; Execution error (ClassCastException) at user/eval308 (REPL:1).
    ; class user$vdiv$tol__293 cannot be cast to class java.lang.Number (user$vdiv$tol__293 is in unnamed module of loader clojure.lang.DynamicClassLoader @543e593; java.lang.Number is in module java.base of loader 'bootstrap')

    ; user=> (* 8 tol)
    ; Execution error (ClassCastException) at user/eval310 (REPL:1).
    ; class user$vdiv$tol__293 cannot be cast to class java.lang.Number (user$vdiv$tol__293 is in unnamed module of loader clojure.lang.DynamicClassLoader @543e593; java.lang.Number is in module java.base of loader 'bootstrap')
    ; user=> (+ 4 (tol 4))
    ; 101/25
    ; user=> (* 8 (tol 5))
    ; 2/5


(defn vdiv [v r1 r2 tol]
    (defn k [r1 r2] (* [r1 r2] 1000))
    (defn M [r1 r2] (* [r1 r2] 1000000))
    (defn tol [tol] (/ tol 100))
    (* v (/ (* r2 (- tol)) 
            (+  (* r1 tol) 
                (* r2 (- tol))
            )
        )
    )
)

(defn vdiv [v r1 r2 tol]
    (let [k (* [r1 r2] 1000)
         M (* [r1 r2] 1000000)
         tol (/ tol 100)])
        (* v 
            (/ 
                (* r2 (- tol)) 
                    (+  (* r1 tol) 
                        (* r2 (- tol))))))




(defn vt [v r1 r2 tol]          ;particular function in question
    (let [tol (/ tol 100)]
        (println [v r1 r2 tol])))

;works
(defn k [x] (* x 1000))         ;globally defined functions
(defn M [x] (* x 1000000))

;works
(defn vt [v r1 r2]
    (float (* v 
              (/ r2  
                 (+ r1 r2)))))

;output
    ; user=> (vt 5 70 70)
    ; 2.5
    ; user=> (vt 12 (k 5) (k 5))
    ; 6.0

;electronics abstraction language ideas
(defn R [x] 
    (let [k {1000} 
    help (println 
"E28: 1.2 1.4 ... E36: 1.2 1.4 ... 
E64: 1.2 1.4 ... E108: 1.2 1.4 ...")]))


;want to type (wtf 5k) and get 5000 output
    ;define engineering-symbols

    (for [exp (vec (range -15 13)), div (/ exp 3) :when (zero? (inc exp))] (prn exp))

    (let [sym (vec (range -15 13))])
    ;[-15 -14 -13 -12 -11 -10 -9 -8 -7 -6 -5 -4 -3 -2 -1 0 1 2 3 4 5 6 7 8 9 10 11 12]

    (let [sym (range -15 13)] 
        (if (int? (/ sym 3)) (int sym)))
    ; class clojure.lang.LongRange cannot be cast to class java.lang.Number 
    
    ;i give up, i'll fucking type it out
    (def engr-units 
        [(def dexp 1)
        (def T (Math/pow 10 12))
        (def G (Math/pow 10 9))
        (def M (Math/pow 10 6))
        (def k (Math/pow 10 3))
        (def m (Math/pow 10 -3))
        (def u (Math/pow 10 -6))
        (def n (Math/pow 10 -9))
        (def p (Math/pow 10 -12))
        (def f (Math/pow 10 -15))])
       

    ;need way to glue these cunts together as ONE fucking thing
        ;using first, rest, cons and that shit
    
    ;takes value and multiplies it by exponent to construct components & signals via quantities
        ;need to construct ONE thing from the result of qnt
    (defn qnt [val exp] (* val exp)) 
         (defn qnt [val dexp & exp] (* val (merge dexp exp))) 
    
    ;works, prob verbose, also cant change output form
    (defn cur [val exp, val2 exp2]
        (let [v (qnt val exp), r (qnt val2 exp2), i (/ v r)] 
            (println (float i))))
            
        ; user=> (* m (cur 9 v 324 r))
        ; 0.027777778
        ; Execution error (NullPointerException) at user/eval173 (REPL:1).
    
     (defn cur [val exp, val2 exp2]
        (let [v (qnt val exp), r (qnt val2 exp2), i (/ v r)] 
            (println (float i))))

    (defn vdiv [])
        
        ; user=> (* m (cur 9 v 324 r))
        ; 0.027777778
        ; Execution error (NullPointerException) at user/eval173 (REPL:1).

    (let [m -3] m)
    ; -3

    ((let [m -3, k 3] (println m k)))
    ; -3 3
    ; Execution error (NullPointerException) at user/eval392 (REPL:1).
    ; null
    ()
    (defn engr-sym [x]
        (let [m -3])
    
    ;trying to model 5k as a list item 
    (defn r [r & more] (vec [r more]))
        
        ; user=> (r 5 k)
        ; Syntax error compiling at (REPL:1:1).
        ; Unable to resolve symbol: k in this context

        ; user=> (r 5 6)
        ;[5 (6)]

        (defn r [r & more] (let [k (def k)] (println r k)))
            ; user=> (r 5 k)
            ; 5 #'user/k
            ; nil
        (defn r [r & more] (let [k (def k 1000)] (* r k)))
            ; user=> (r 5 k)
            ; Execution error (ClassCastException) at user/r (REPL:1).
            ; class clojure.lang.Var cannot be cast to class java.lang.Number (clojure.lang.Var is in unnamed module of loader 'app'; java.lang.Number is in module java.base of loader 'bootstrap')
    
    ;define engineering numeric notation

    (defn wtf [& x] 
        (let [M (* 5 5)]))
        
        ; user=> (wtf M)
        ; Syntax error compiling at (REPL:1:1).
        ; Unable to resolve symbol: M in this context

    (defn wtf [& x] 
        (let [k 1000]))

        ; user=> (wtf k)
        ; Syntax error compiling at (REPL:1:1).
        ; Unable to resolve symbol: k in this context

    (defn wtf [x] (if (= x k) 1000))
        ; Syntax error compiling at (REPL:1:1).
        ; Unable to resolve symbol: k in this context

    (defn wtf [x] (if (= x "k") 1000))
        ; user=> (wtf "k")
        ; 1000

    (defn wtf [x] (if (= x \k) 1000))
        ; user=> (wtf k)
            ; Syntax error compiling at (REPL:1:1).
            ; Unable to resolve symbol: k in this context

        ; user=> (wtf \k)
            ; 1000

    user=> (defn wtf [x] (if (= x 'k) 1000))

        ; user=> (wtf k)
            ; Syntax error compiling at (REPL:1:1).
            ; Unable to resolve symbol: k in this context
        
        ; user=> (wtf 'k)
            ; 1000

    (defn wtf [x] (if (= x 2) 1000))
        ; user=> (wtf 2)
        ; 1000

    (let [k 1000] k)
        ; 1000

;old noob code
    ; (defn vt [v r1 r2 tol]          ;particular function in question
    ; (defn tol [tol] (/ tol 100))
    ;     (println [v r1 r2 tol]))

