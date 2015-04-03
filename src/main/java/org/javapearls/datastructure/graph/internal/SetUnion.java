package org.javapearls.datastructure.graph.internal;

public class SetUnion {

	private int[] parent;		// parent
	private int[] size;			// the number element in subtree i
	private int n;				// the size of the set

	public SetUnion(int total){
		parent = new int[total + 1];
		size = new int[total + 1];
		n = total;
		init();
	}

	private void init(){
		for (int i = 1; i <= n; i++){
			parent[i] = i;		// parent to itself
			size[i] = 1;		// one element per tree
		}
	}

	public int find(int x){
		if (parent[x] == x){
			return x;
		}else {
			return find(parent[x]);
		}
	}

	public void union(int s1, int s2){
		if (s1 == s2) return;

		int r1 = find(s1);
		int r2 = find(s2);
		if (r1 == r2){ // on the same tree already
			return;
		}

		// merge two trees ... smaller one to big one
		if (size[r1] >= size[r2]){
			size[r1] = size[r1] + size[r2];
			parent[r2] = r1;
		}else{
			size[r2] = size[r2] + size[r1];
			parent[r1] = r2;
		}
	}

	public boolean sameComponents(int s1, int s2){
		return (find(s1) == find(s2));
	}

}
