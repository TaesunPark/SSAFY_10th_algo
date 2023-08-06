package user;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main24060 {
	static int n, k, a[], tmp[], cnt, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		a = new int[n];
		tmp = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		merge_sort(0, n - 1);
		if (cnt < k) {
			System.out.println(-1);
		} else
			System.out.println(res);
	}

	private static void merge_sort(int p, int r) {
		if(p<r) {
			int q = Math.abs((p + r) / 2);
			merge_sort(p, q);
			merge_sort(q + 1, r);
			merge(p, q, r);
		}
		

	}

	private static void merge(int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;
		while (i <= q && j <= r) {
			if (a[i] <= a[j]) {
				tmp[t++] = a[i++];
			} else
				tmp[t++] = a[j++];
		}

		while (i <= q)
			tmp[t++] = a[i++];
		while (j <= r)
			tmp[t++] = a[j++];
		i = p;
		t = 0;
		while (i <= r) {
			cnt++;
			if (cnt == k) {
				res = tmp[t];
			}
			a[i++] = tmp[t++];
		}

	}

}