package id.co.roxas.efim;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import id.co.roxas.efim.dao.TblDataUserTesterDao;

@SpringBootApplication
public class EfimCoreIbatisApplication implements CommandLineRunner{


	public static void main(String[] args) {
		SpringApplication.run(EfimCoreIbatisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(this.cityMapper.findByState("CA"));
	}

}
