package com.health.fitness;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
 
public class Lab4_1_HealthIndexScoreTest {
 
    // Nominal values (mid-range, valid for every variable)
    private static final double NOM_VO2 = 35.0;
    private static final int NOM_RHR = 70;
    private static final int NOM_HRR = 15;
 
    @Test
    @DisplayName("TC01: All nominal -> VO2=35(2) + RHR=70(3) + HRR=15(3) = 8 (Standard)")
    void tc01_allNominal() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, NOM_RHR, NOM_HRR);
        assertEquals(2, h.calculateVo2MaxScore());
        assertEquals(3, h.calculateRhrScore());
        assertEquals(3, h.calculateHrrScore());
        assertEquals(8, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }
 
    @Test
    @DisplayName("TC02: VO2Max = MIN (0)")
    void tc02_vo2Max_min() {
        HealthIndexScore h = new HealthIndexScore(0.0, NOM_RHR, NOM_HRR);
        assertEquals(0, h.calculateVo2MaxScore());
        assertEquals(6, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }
 
    @Test
    @DisplayName("TC03: VO2Max = MIN+ (1)")
    void tc03_vo2Max_minPlus() {
        HealthIndexScore h = new HealthIndexScore(1.0, NOM_RHR, NOM_HRR);
        assertEquals(0, h.calculateVo2MaxScore());
        assertEquals(6, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }
 
    @Test
    @DisplayName("TC04: VO2Max = MAX- (99)")
    void tc04_vo2Max_maxMinus() {
        HealthIndexScore h = new HealthIndexScore(99.0, NOM_RHR, NOM_HRR);
        assertEquals(5, h.calculateVo2MaxScore());
        assertEquals(11, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }
 
    @Test
    @DisplayName("TC05: VO2Max = MAX (100)")
    void tc05_vo2Max_max() {
        HealthIndexScore h = new HealthIndexScore(100.0, NOM_RHR, NOM_HRR);
        assertEquals(5, h.calculateVo2MaxScore());
        assertEquals(11, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }
 
    @Test
    @DisplayName("TC06: RHR = MIN (40)")
    void tc06_rhr_min() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, 40, NOM_HRR);
        assertEquals(5, h.calculateRhrScore());
        assertEquals(10, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }
 
    @Test
    @DisplayName("TC07: RHR = MIN+ (41)")
    void tc07_rhr_minPlus() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, 41, NOM_HRR);
        assertEquals(5, h.calculateRhrScore());
        assertEquals(10, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }
 
    @Test
    @DisplayName("TC08: RHR = MAX- (219)")
    void tc08_rhr_maxMinus() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, 219, NOM_HRR);
        assertEquals(1, h.calculateRhrScore());
        assertEquals(6, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }
 
    @Test
    @DisplayName("TC09: RHR = MAX (220)")
    void tc09_rhr_max() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, 220, NOM_HRR);
        assertEquals(1, h.calculateRhrScore());
        assertEquals(6, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }
 
    @Test
    @DisplayName("TC10: HRR = MIN (0)")
    void tc10_hrr_min() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, NOM_RHR, 0);
        assertEquals(1, h.calculateHrrScore());
        assertEquals(6, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }
 
    @Test
    @DisplayName("TC11: HRR = MIN+ (1)")
    void tc11_hrr_minPlus() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, NOM_RHR, 1);
        assertEquals(1, h.calculateHrrScore());
        assertEquals(6, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }
 
    @Test
    @DisplayName("TC12: HRR = MAX- (49)")
    void tc12_hrr_maxMinus() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, NOM_RHR, 49);
        assertEquals(5, h.calculateHrrScore());
        assertEquals(10, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }
 
    @Test
    @DisplayName("TC13: HRR = MAX (50)")
    void tc13_hrr_max() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, NOM_RHR, 50);
        assertEquals(5, h.calculateHrrScore());
        assertEquals(10, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }
}