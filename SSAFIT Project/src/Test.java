import java.io.IOException;

import com.ssafy.fit.model.dao.VideoDao;
import com.ssafy.fit.model.dao.VideoDaoImpl;

public class Test {
	public static void main(String[] args) throws IOException {
		VideoDao vm = VideoDaoImpl.getInstance();
		System.out.println(((VideoDaoImpl) vm).listConstruct());
	}
	
}