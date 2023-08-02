package user;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main2910 {
	static long n, c ;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		Map<Integer, Integer> binMap = new HashMap<>();
		Map<Integer, Integer> firstMap = new HashMap<>();
		for(int i=0;i<n;i++) {
			int now = Integer.parseInt(st.nextToken());
			binMap.put(now, binMap.getOrDefault(now, 0)+1);
			if(firstMap.getOrDefault(now, -1)==-1) {
				firstMap.put(now, i);
				
			}
		}
		
		List<Integer> num = new ArrayList<>();
		binMap.forEach((k,v)->{
			num.add(k);
		});
		
		Collections.sort(num, (o1, o2)->{
			if(binMap.get(o1)==binMap.get(o2))return firstMap.get(o1) - firstMap.get(o2);
			return binMap.get(o2)-binMap.get(o1);
		});
		
		for(int x: num) {
			for(int i=0;i<binMap.get(x);i++) {
				System.out.print(x+" ");
			}
		}
	}

}