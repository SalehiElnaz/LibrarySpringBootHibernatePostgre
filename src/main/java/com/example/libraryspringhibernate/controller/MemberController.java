package com.example.libraryspringhibernate.controller;


        import com.example.libraryspringhibernate.exeption.ResourceNotFoundException;
        import com.example.libraryspringhibernate.model.Member;
        import com.example.libraryspringhibernate.repository.MemberRepository;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
//import javax.validation.Valid;

@RestController
@RequestMapping("/api/")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @GetMapping("member")
    public List<Member> getAllMembers(){
        logger.info("getAllMembers called...");
        return memberRepository.findAll();
    }

    @GetMapping("member/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable(value = "id") Long memberId)
            throws ResourceNotFoundException {
        logger.info("getMemberById called...id :"+memberId);
        Member member=memberRepository.findById(memberId).orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: "+memberId));
        return ResponseEntity.ok().body(member);
    }

    //    public Member createMember(@Valid @RequestBody Member Member){
    @PostMapping("newMember")
    public Member createMember(@RequestBody Member member){
        logger.info("getMemberById called...MemberName :"+member.getMemberName() +"  Password :"+member.getPassword());
        return memberRepository.save(member);
    }

    @PutMapping("member/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable(value = "id") Long memberId,
                                           @RequestBody Member memberDetails) throws ResourceNotFoundException {
        logger.info("updateMember called...id :"+memberId);
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + memberId));

        member.setMemberId(memberDetails.getMemberId());
        member.setMemberName(memberDetails.getMemberName());
        member.setPassword(memberDetails.getPassword());

        final Member updatedMember = memberRepository.save(member);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("member/{id}")
    public Map<String, Boolean> deleteMember(@PathVariable(value = "id") Long memberId)
            throws ResourceNotFoundException {
        logger.info("deleteMember called...id :"+memberId);
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found for this id :: " + memberId));

        memberRepository.delete(member);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
