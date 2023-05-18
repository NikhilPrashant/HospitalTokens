package com.example.HospitalTokensGenerator.Functions;
import com.example.HospitalTokensGenerator.Entities.SlipEntity;
import com.example.HospitalTokensGenerator.Entities.TokenEntity;
import com.example.HospitalTokensGenerator.Repositories.SlipRepository;
import com.example.HospitalTokensGenerator.Repositories.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SlipGenerator {

//    @Autowired
//    private static SlipRepository slipRepository;

//    @Autowired
//    private static TokenRepository tokenRepository;

    private static SlipRepository slipRepository;
    private static TokenRepository tokenRepository;

    @Autowired
    public SlipGenerator(SlipRepository slipRepository, TokenRepository tokenRepository) {
        this.slipRepository = slipRepository;
        this.tokenRepository = tokenRepository;
    }

    public static int getCurrSlip() {
        System.out.println(1);
        dayChangeResetSlip();
        SlipEntity slip = slipRepository.findById(1).get();
        int currSlip = slip.getCurrSlip();
        slip.setCurrSlip(currSlip + 1);
        slipRepository.save(slip);
        return currSlip;
    }

    public static void dayChangeResetSlip() {
        System.out.println(2);
        SlipEntity slipEntity = slipRepository.findById(1).get();
        System.out.println(slipEntity);
        if (!slipRepository.existsById(1)) {
            System.out.println(3);
            slipRepository.save(new SlipEntity(1, 1, LocalDate.now()));
            return;
        }
        System.out.println(4);
        SlipEntity slip = slipRepository.findById(1).get();
        LocalDate currDate = slip.getLocalDate();
//        if (!LocalDate.of(2023, 05, 20).equals(LocalDate.of(2023, 05, 20))) {
        if (!LocalDate.now().equals(currDate)) {
//            tokenRepository.cancelTokens();
//            tokenRepository.deactivateTokens();
            // Above was not working because of Safe update Mode so instead used this
            List<TokenEntity> tokenEntities = tokenRepository.findAll();
            for (TokenEntity tokenEntity: tokenEntities) {
                if (tokenEntity.isActive()) {
                    tokenEntity.setCancelled(true);
                    tokenEntity.setActive(false);
                }
            }
            tokenRepository.saveAll(tokenEntities);
            // Here
            slip.setCurrSlip(1);
            slip.setLocalDate(LocalDate.now());
            slipRepository.save(slip);
        }
    }
}
