(ns x4clojure.solutions-test
  (:require
    [clojure.test :refer :all]
    [x4clojure.solutions :refer :all]))

(deftest problem-26-fibonacci
  (is (= (fibo 3) '(1 1 2)))
  (is (= (fibo 6) '(1 1 2 3 5 8)))
  (is (= (fibo 8) '(1 1 2 3 5 8 13 21))))

(deftest problem-28-flatten-a-sequence
  (is (= (my-flatten '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)))
  (is (= (my-flatten ["a" ["b"] "c"]) '("a" "b" "c")))
  (is (= (my-flatten '((((:a))))) '(:a))))

(deftest problem-29-get-the-caps
  (is (= (get-the-caps "HeLlO, WoRlD!") "HLOWRD"))
  (is (empty? (get-the-caps "nothing")))
  (is (= (get-the-caps "$#A(*&987Zf") "AZ")))

(deftest problem-30-compress-a-sequence
  (is (= (apply str (my-dedupe "Leeeeeerrroyyy")) "Leroy"))
  (is (= (my-dedupe [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
  (is (= (my-dedupe [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))))

(deftest problem-32-duplicate-a-sequence
  (is (= (duplicate-seq [1 2 3]) '(1 1 2 2 3 3)))
  (is (= (duplicate-seq [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))
  (is (= (duplicate-seq [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))
  (is (= (duplicate-seq [44 33]) [44 44 33 33])))

(deftest problem-34-implement-range
  (is (= (my-range 1 4) '(1 2 3)))
  (is (= (my-range -2 2) '(-2 -1 0 1)))
  (is (= (my-range 5 8) '(5 6 7))))

(deftest problem-39-interleave-two-seq
  (is (= (my-interleave [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)))
  (is (= (my-interleave [1 2] [3 4 5 6]) '(1 3 2 4)))
  (is (= (my-interleave [1 2 3 4] [5]) [1 5]))
  (is (= (my-interleave [30 20] [25 15]) [30 25 20 15])))

(deftest problem-40-interpose-a-seq
  (is (= (my-interpose 0 [1 2 3]) [1 0 2 0 3]))
  (is (= (apply str (my-interpose ", " ["one" "two" "three"])) "one, two, three"))
  (is (= (my-interpose :z [:a :b :c :d]) [:a :z :b :z :c :z :d])))

(deftest problem-41-drop-every-nth-item
  (is (= (drop-every-nth [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))
  (is (= (drop-every-nth [:a :b :c :d :e :f] 2) [:a :c :e]))
  (is (= (drop-every-nth [1 2 3 4 5 6] 4) [1 2 3 5 6])))

(deftest problem-42-factorial-fun
  (is (= (factorial-fun 1) 1))
  (is (= (factorial-fun 3) 6))
  (is (= (factorial-fun 5) 120))
  (is (= (factorial-fun 8) 40320)))

(deftest problem-43-reverse-interleave
  (is (= (reverse-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))))
  (is (= (reverse-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))))
  (is (= (reverse-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))))

(deftest problem-44-rotate-seq
  (is (= (rotate-seq 2 [1 2 3 4 5]) '(3 4 5 1 2)))
  (is (= (rotate-seq -2 [1 2 3 4 5]) '(4 5 1 2 3)))
  (is (= (rotate-seq 6 [1 2 3 4 5]) '(2 3 4 5 1)))
  (is (= (rotate-seq 1 '(:a :b :c)) '(:b :c :a)))
  (is (= (rotate-seq -4 '(:a :b :c)) '(:c :a :b))))

(deftest problem-46-flipping-out
  (is (= 3 ((flip-out nth) 2 [1 2 3 4 5])))
  (is (= true ((flip-out >) 7 8)))
  (is (= 4 ((flip-out quot) 2 8)))
  (is (= [1 2 3] ((flip-out take) [1 2 3 4 5] 3))))

(deftest problem-50-split-by-type
  (is (= (set (split-by-type [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}))
  (is (= (set (split-by-type [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]}))
  (is (= (set (split-by-type [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})))

(deftest problem-53-longest-incr-subs
  (is (= (longest-incr-subs [1 0 1 2 3 0 4 5]) [0 1 2 3]))
  (is (= (longest-incr-subs [5 6 1 3 2 7]) [5 6]))
  (is (= (longest-incr-subs [2 3 3 4 5]) [3 4 5]))
  (is (= (longest-incr-subs [7 6 5 4]) [])))

; TODO: create a macro to translate plain 4clojure code format to this?
(deftest problem-54-partition-a-sequence
  (is (= (my-partition 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8))))
  (is (= (my-partition 2 (range 8)) '((0 1) (2 3) (4 5) (6 7))))
  (is (= (my-partition 3 (range 8)) '((0 1 2) (3 4 5)))))

(deftest problem-55-count-occurrences
  (is (= (count-occurences [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}))
  (is (= (count-occurences [:b :a :b :a :b]) {:a 2, :b 3}))
  (is (= (count-occurences '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})))

(deftest problem-56-find-distinct-items
  (is (= (my-distinct [1 2 1 3 1 2 4]) [1 2 3 4]))
  (is (= (my-distinct [:a :a :b :b :c :c]) [:a :b :c]))
  (is (= (my-distinct '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3])))
  (is (= (my-distinct (range 50)) (range 50))))

(deftest problem-58-function-composition
  (is (= [3 2 1] ((my-comp rest reverse) [1 2 3 4])))
  (is (= 5 ((my-comp (partial + 3) second) [1 2 3 4])))
  (is (= true ((my-comp zero? #(mod % 8) +) 3 5 7 9)))
  (is (= "HELLO" ((my-comp #(.toUpperCase %) #(apply str %) take) 5 "hello world"))))

(deftest problem-59-juxt
  (is (= [21 6 1] ((my-juxt + max min) 2 3 5 1 6 4)))
  (is (= ["HELLO" 5] ((my-juxt #(.toUpperCase %) count) "hello")))
  (is (= [2 6 4] ((my-juxt :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))))
