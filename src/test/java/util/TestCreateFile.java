package util;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestCreateFile {

	static final String path = "./hola/adios/";
	
	@BeforeAll
	static void clear() {
		new File(path).delete();
	}
	
	@Test
	void testCreatePath() {
		File f = new File(path);
		assertFalse(f.exists());
		CreateFile.createPath(f.toString());
		assertTrue(f.exists());
	}

}
