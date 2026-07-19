package com.health.fitness;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * Name: [ชื่อ-นามสกุล]
 * SID: [รหัสนักศึกษา]
 * Lab#4.1 - Normal Boundary Value Testing
 */
class Lab4_1_HealthIndexScoreTest {

    // Nominal values (mid-range, not touching any boundary)
    private static final double NOMINAL_VO2MAX = 35.0;
    private static final int NOMINAL_RHR = 70;
    private static final int NOMINAL_HRR = 15;

    // ---------- VO2 Max Score ----------
    @Test
    @DisplayName("TC01: VO2Max=24 -> score 0 (very poor)")
    void testVo2Max_24() {
        HealthIndexScore h = new HealthIndexScore(24, NOMINAL_RHR, NOMINAL_HRR);
        assertEquals(0, h.calculateVo2MaxScore());
    }

    @Test
    @DisplayName("TC02: VO2Max=25 -> score 1 (poor)")
    void testVo2Max_25() {
        HealthIndexScore h = new HealthIndexScore(25, NOMINAL_RHR, NOMINAL_HRR);
        assertEquals(1, h.calculateVo2MaxScore());
    }

    @Test
    @DisplayName("TC03: VO2Max=30 -> score 1 (poor)")
    void testVo2Max_30() {
        HealthIndexScore h = new HealthIndexScore(30, NOMINAL_RHR, NOMINAL_HRR);
        assertEquals(1, h.calculateVo2MaxScore());
    }

    @Test
    @DisplayName("TC04: VO2Max=31 -> score 2 (normal)")
    void testVo2Max_31() {
        HealthIndexScore h = new HealthIndexScore(31, NOMINAL_RHR, NOMINAL_HRR);
        assertEquals(2, h.calculateVo2MaxScore());
    }

    @Test
    @DisplayName("TC05: VO2Max=40 -> score 2 (normal)")
    void testVo2Max_40() {
        HealthIndexScore h = new HealthIndexScore(40, NOMINAL_RHR, NOMINAL_HRR);
        assertEquals(2, h.calculateVo2MaxScore());
    }

    @Test
    @DisplayName("TC06: VO2Max=41 -> score 3 (good)")
    void testVo2Max_41() {
        HealthIndexScore h = new HealthIndexScore(41, NOMINAL_RHR, NOMINAL_HRR);
        assertEquals(3, h.calculateVo2MaxScore());
    }

    @Test
    @DisplayName("TC07: VO2Max=50 -> score 3 (good)")
    void testVo2Max_50() {
        HealthIndexScore h = new HealthIndexScore(50, NOMINAL_RHR, NOMINAL_HRR);
        assertEquals(3, h.calculateVo2MaxScore());
    }

    @Test
    @DisplayName("TC08: VO2Max=51 -> score 4 (very good)")
    void testVo2Max_51() {
        HealthIndexScore h = new HealthIndexScore(51, NOMINAL_RHR, NOMINAL_HRR);
        assertEquals(4, h.calculateVo2MaxScore());
    }

    @Test
    @DisplayName("TC09: VO2Max=60 -> score 4 (very good)")
    void testVo2Max_60() {
        HealthIndexScore h = new HealthIndexScore(60, NOMINAL_RHR, NOMINAL_HRR);
        assertEquals(4, h.calculateVo2MaxScore());
    }

    @Test
    @DisplayName("TC10: VO2Max=61 -> score 5 (athlete)")
    void testVo2Max_61() {
        HealthIndexScore h = new HealthIndexScore(61, NOMINAL_RHR, NOMINAL_HRR);
        assertEquals(5, h.calculateVo2MaxScore());
    }

    // ---------- Resting Heart Rate Score ----------
    @Test
    @DisplayName("TC11: RHR=40 -> score 5 (excellent)")
    void testRhr_40() {
        HealthIndexScore h = new HealthIndexScore(NOMINAL_VO2MAX, 40, NOMINAL_HRR);
        assertEquals(5, h.calculateRhrScore());
    }

    @Test
    @DisplayName("TC12: RHR=60 -> score 5 (excellent)")
    void testRhr_60() {
        HealthIndexScore h = new HealthIndexScore(NOMINAL_VO2MAX, 60, NOMINAL_HRR);
        assertEquals(5, h.calculateRhrScore());
    }

    @Test
    @DisplayName("TC13: RHR=61 -> score 3 (normal)")
    void testRhr_61() {
        HealthIndexScore h = new HealthIndexScore(NOMINAL_VO2MAX, 61, NOMINAL_HRR);
        assertEquals(3, h.calculateRhrScore());
    }

    @Test
    @DisplayName("TC14: RHR=84 -> score 3 (normal)")
    void testRhr_84() {
        HealthIndexScore h = new HealthIndexScore(NOMINAL_VO2MAX, 84, NOMINAL_HRR);
        assertEquals(3, h.calculateRhrScore());
    }

    @Test
    @DisplayName("TC15: RHR=85 -> score 1 (poor)")
    void testRhr_85() {
        HealthIndexScore h = new HealthIndexScore(NOMINAL_VO2MAX, 85, NOMINAL_HRR);
        assertEquals(1, h.calculateRhrScore());
    }

    @Test
    @DisplayName("TC16: RHR=220 (max valid) -> score 1 (poor)")
    void testRhr_220() {
        HealthIndexScore h = new HealthIndexScore(NOMINAL_VO2MAX, 220, NOMINAL_HRR);
        assertEquals(1, h.calculateRhrScore());
    }

    // ---------- Heart Rate Recovery Score ----------
    @Test
    @DisplayName("TC17: HRR=11 -> score 1 (poor)")
    void testHrr_11() {
        HealthIndexScore h = new HealthIndexScore(NOMINAL_VO2MAX, NOMINAL_RHR, 11);
        assertEquals(1, h.calculateHrrScore());
    }

    @Test
    @DisplayName("TC18: HRR=12 -> score 3 (good)")
    void testHrr_12() {
        HealthIndexScore h = new HealthIndexScore(NOMINAL_VO2MAX, NOMINAL_RHR, 12);
        assertEquals(3, h.calculateHrrScore());
    }

    @Test
    @DisplayName("TC19: HRR=18 -> score 3 (good)")
    void testHrr_18() {
        HealthIndexScore h = new HealthIndexScore(NOMINAL_VO2MAX, NOMINAL_RHR, 18);
        assertEquals(3, h.calculateHrrScore());
    }

    @Test
    @DisplayName("TC20: HRR=19 -> score 4 (very good)")
    void testHrr_19() {
        HealthIndexScore h = new HealthIndexScore(NOMINAL_VO2MAX, NOMINAL_RHR, 19);
        assertEquals(4, h.calculateHrrScore());
    }

    @Test
    @DisplayName("TC21: HRR=24 -> score 4 (very good)")
    void testHrr_24() {
        HealthIndexScore h = new HealthIndexScore(NOMINAL_VO2MAX, NOMINAL_RHR, 24);
        assertEquals(4, h.calculateHrrScore());
    }

    @Test
    @DisplayName("TC22: HRR=25 -> score 5 (athlete)")
    void testHrr_25() {
        HealthIndexScore h = new HealthIndexScore(NOMINAL_VO2MAX, NOMINAL_RHR, 25);
        assertEquals(5, h.calculateHrrScore());
    }

    // ---------- Total Score / Fitness Level Boundary ----------
    @Test
    @DisplayName("TC23: Total=5 -> POOR")
    void testTotalScore_5_isPoor() {
        // VO2=0(24) + RHR=1(90) + HRR=4(20) = 5
        HealthIndexScore h = new HealthIndexScore(24, 90, 20);
        assertEquals(5, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.POOR, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC24: Total=6 -> STANDARD")
    void testTotalScore_6_isStandard() {
        // VO2=1(25) + RHR=1(90) + HRR=4(20) = 6
        HealthIndexScore h = new HealthIndexScore(25, 90, 20);
        assertEquals(6, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC25: Total=11 -> STANDARD")
    void testTotalScore_11_isStandard() {
        // VO2=3(45) + RHR=3(70) + HRR=5(25) = 11
        HealthIndexScore h = new HealthIndexScore(45, 70, 25);
        assertEquals(11, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC26: Total=12 -> EXCELLENT")
    void testTotalScore_12_isExcellent() {
        // VO2=4(55) + RHR=3(70) + HRR=5(25) = 12
        HealthIndexScore h = new HealthIndexScore(55, 70, 25);
        assertEquals(12, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.EXCELLENT, h.getFitnessLevel());
    }
}