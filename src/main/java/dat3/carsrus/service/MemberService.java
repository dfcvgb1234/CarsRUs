package dat3.carsrus.service;

import dat3.carsrus.dto.car.CarRequest;
import dat3.carsrus.dto.car.CarResponse;
import dat3.carsrus.dto.member.MemberRequest;
import dat3.carsrus.dto.member.MemberResponse;
import dat3.carsrus.entity.Member;
import dat3.carsrus.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService extends dat3.carsrus.service.Service<Member, MemberRequest, MemberResponse, String> {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public MemberResponse getById(String id) {
        return super.getById(id, memberRepository, MemberResponse.class, Member.class);
    }

    @Override
    public List<MemberResponse> getAll() {
        return super.getAll(memberRepository, MemberResponse.class, Member.class);
    }

    @Override
    public void addNew(MemberRequest body) {
        super.addNew(body, memberRepository);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id, memberRepository);
    }

    @Override
    public void updateById(String id, MemberRequest body) {
        super.updateById(id, body, memberRepository);
    }
}
