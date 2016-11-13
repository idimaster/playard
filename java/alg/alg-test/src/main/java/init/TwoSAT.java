package init;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * Created by Dnitry on 5/9/2015.
 */
public class TwoSAT {

    static class SAT {
        final int x;
        final int y;

        public SAT(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class VarDec {
        Boolean valA;
        Boolean valB;
        List<SAT> sat;

        public void addSAT(SAT s) {
            if(sat == null)
                sat = new ArrayList<SAT>();
            sat.add(s);
        }
    }

    static class Decision {
        final int var;
        final boolean val;

        public Decision(int var, boolean val) {
            this.val = val;
            this.var = var;
        }
    }

    private VarDec var[];
    private Deque<SAT> A = new ArrayDeque<SAT>();
    private Deque<SAT> B = new ArrayDeque<SAT>();

    public int getCount() {
        return var.length;
    }

    public void load(URL url) throws IOException {
        Scanner s = new Scanner(url.openStream());

        try {
            int size = s.nextInt();
            var = new VarDec[size];
            while (true) {
                int node1 = s.nextInt();
                int node2 = s.nextInt();
                if(var[Math.abs(node1)-1] == null) var[Math.abs(node1)-1] = new VarDec();
                if(var[Math.abs(node2)-1] == null) var[Math.abs(node2)-1] = new VarDec();
                var[Math.abs(node1)-1].addSAT(new SAT(node1, node2));
                var[Math.abs(node2)-1].addSAT(new SAT(node2, node1));
            }
        } catch(NoSuchElementException e) {}
    }

    public boolean calcSatisfiability() {
      //  Decision decision = null;

        List<Integer> changesA  = new ArrayList<Integer>();
        List<Integer> changesB  = new ArrayList<Integer>();
        for(int i = 0; i < var.length; i++) {
            if (var[i] != null && var[i].valA == null) {
              //  if(decision == null) decision = new Decision(i, true);
                var[i].valA = true;
                var[i].valB = false;
                changesA.add(i);
                changesB.add(i);
                if(checkSAT(i))return false;
                while (A.size() > 0 && B.size() > 0) {
                    SAT sat = A.removeFirst();
                    int idx = Math.abs(sat.y) - 1;
                    var[idx].valA = sat.y > 0;
                    changesA.add(idx);
                    if(checkSAT(idx))return false;
                    sat = B.removeFirst();
                    idx = Math.abs(sat.y) - 1;
                    var[idx].valB = sat.y > 0;
                    changesB.add(idx);
                }
                if (A.size() == 0) {
                    for (Integer idx :changesB){
                        var[idx].valB = null;
                    }
                    for (Integer idx :changesA){
                       var[idx].valB = var[idx].valA;
                    }
                } else {
                    for (Integer idx :changesA){
                        var[idx].valA = null;
                    }
                    for (Integer idx :changesB){
                        var[idx].valA = var[idx].valB;
                    }
                }
                changesA.clear();
                changesB.clear();
            }
        }
        return true;
    }

    private boolean checkSAT(int idx) {
        boolean abortA = false;
        boolean abortB = false;
        for(SAT s : var[idx].sat){
            int ref = Math.abs(s.y) - 1;
            Boolean b = checkTrueA(s, idx, ref);
            if(b == null) {
                A.addLast(s);
            } else {
                abortA = abortA |(!b);
            }
            b = checkTrueB(s, idx, ref);
            if(b == null) {
                B.addLast(s);
            } else {
                abortB = abortB |(!b);
            }
            if (abortA && abortB) return true;
        }
        return false;
    }


    private Boolean checkTrueA(SAT s, int i, int idx) {
        if(var[i].valA == null)return true; // happens only for B calculation
        if(var[idx].valA == null) {
            if (s.x > 0 && var[i].valA) return true;
            if (s.x < 0 && !var[i].valA) return true;
            return var[idx].valA;
        }
        boolean b1 = s.x > 0 ? var[i].valA : !var[i].valA;
        boolean b2 = s.y > 0 ? var[idx].valA : !var[idx].valA;
        return b1|b2;
    }

    private Boolean checkTrueB(SAT s, int i, int idx) {
        if(var[i].valB == null)return true; // happens only for A calculation
        if(var[idx].valB == null) {
            if (s.x > 0 && var[i].valB) return true;
            if (s.x < 0 && !var[i].valB) return true;
            return var[idx].valB;
        }
        boolean b1 = s.x > 0 ? var[i].valB : !var[i].valB;
        boolean b2 = s.y > 0 ? var[idx].valB : !var[idx].valB;
        return b1|b2;
    }
}
