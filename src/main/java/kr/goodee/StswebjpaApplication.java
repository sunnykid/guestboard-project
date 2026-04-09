package kr.goodee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kr.goodee.mem.Member;
import kr.goodee.mem.MemberRepository;

@SpringBootApplication
public class StswebjpaApplication implements CommandLineRunner {
	@Autowired
    private MemberRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(StswebjpaApplication.class, args);
	}
	@Override
    public void run(String... args) {
//        repository.save(new Member("김태형","뷔","btsvui@aaa.bbb"));
//        repository.save(new Member("김남준","RM","RM@aaa.bbb"));
//        repository.save(new Member("민윤기","슈가","btssuga@aaa.bbb"));
//
//        System.out.println("\nfindAll()");
//        repository.findAll().forEach(x -> System.out.println(x));
    }
}
