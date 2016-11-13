package interview2;

import java.util.List;
import java.util.Set;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public class DependencyCycles {
    public static class Reference {
        public final int row;
        public final int col;

        public Reference(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Reference)) return false;
            Reference ref = (Reference)obj;

            return row == ref.row && col == ref.col;
        }

        public int getHashCode() {
            return row * 32 +col;
        }
    }

    final private List<List<List<Reference>>> sheet;

    public DependencyCycles(List<List<List<Reference>>> sheet) {
        if (sheet == null) {
            throw new IllegalArgumentException("sheet cannot be null");
        }
        this.sheet = sheet;
    }

    public List<Reference> ceck() {
        List<Reference> result = new ArrayList<Reference>();
        for(int i = 0; i < sheet.size(); i++) {
            List<List<Reference>> row = sheet.get(i);
            if (row != null) {
                for(int j = 0; j < row.size(); j++) {
                    Reference ref = new Reference(i, j);
                    if (dfsCycle(ref)) {
                        result.add(ref);
                    }
                }
            }
        }
        return result;
    }

    private boolean dfsCycle(Reference item) {
        List<Reference> references = sheet.get(item.row).get(item.col);
        if (references != null) {
            Deque<Reference> stack = new ArrayDeque<Reference>();
            Set<Reference> marks = new HashSet<Reference>();
            stack.push(item);
            do {
                Reference ref = stack.pop();
                if (ref != item && ref.equals(item))
                    return true;
                if (!marks.contains(ref)) {
                    marks.add(ref);
                    if (item.equals(ref)) return true;
                    List<Reference> refs = sheet.get(ref.row).get(ref.col);
                    for(Reference r : refs) {
                        stack.push(r);
                    }
                }

            } while(!stack.isEmpty());
        }
        return false;
    }
}