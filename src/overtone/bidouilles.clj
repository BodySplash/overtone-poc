(use 'overtone.live)


(definst foo [] (saw 220))

(definst bar [freq 440] (saw freq))

(definst trem [freq 440 depth 10 rate 6 length 3]
         (* 0.3
            (line:kr 0 1 length FREE)
            (saw (+ freq (* depth (sin-osc:kr rate))))))

(defn rampup []
  (demo 7 (lpf (mix (saw [50 (line 100 1600 5) 101 100.5]))
               (lin-lin (lf-tri (line 2 20 5)) -1 1 400 4000))))

(definst sin-wave [freq 440 attack 0.01 sustain 0.4 release 0.1 vol 0.4]
         (* (env-gen (lin attack sustain release) 1 1 0 1 FREE)
            (sin-osc freq)
            vol))