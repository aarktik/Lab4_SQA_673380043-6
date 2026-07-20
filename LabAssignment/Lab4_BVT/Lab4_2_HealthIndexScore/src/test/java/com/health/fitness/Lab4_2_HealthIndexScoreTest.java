package com.health.fitness;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class Lab4_2_HealthIndexScoreTest {

    private static final double NOM_VO2 = 35.0;
    private static final int NOM_RHR = 70;
    private static final int NOM_HRR = 15;

    // =========================================================
    // Part A - Normal Boundary Value points (same 13 cases as Lab4.1)
    // =========================================================

    @Test
    @DisplayName("TC01: All nominal -> total = 8 (Standard)")
    void tc01_allNominal() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, NOM_RHR, NOM_HRR);
        assertEquals(8, h.getTotalScore());
        assertEquals(HealthIndexScore.FitnessLevel.STANDARD, h.getFitnessLevel());
    }

    @Test
    @DisplayName("TC02: VO2Max = MIN (0)")
    void tc02_vo2Max_min() {
        HealthIndexScore h = new HealthIndexScore(0.0, NOM_RHR, NOM_HRR);
        assertEquals(0, h.calculateVo2MaxScore());
        assertEquals(6, h.getTotalScore());
    }

    @Test
    @DisplayName("TC03: VO2Max = MIN+ (1)")
    void tc03_vo2Max_minPlus() {
        HealthIndexScore h = new HealthIndexScore(1.0, NOM_RHR, NOM_HRR);
        assertEquals(0, h.calculateVo2MaxScore());
        assertEquals(6, h.getTotalScore());
    }

    @Test
    @DisplayName("TC04: VO2Max = MAX- (99)")
    void tc04_vo2Max_maxMinus() {
        HealthIndexScore h = new HealthIndexScore(99.0, NOM_RHR, NOM_HRR);
        assertEquals(5, h.calculateVo2MaxScore());
        assertEquals(11, h.getTotalScore());
    }

    @Test
    @DisplayName("TC05: VO2Max = MAX (100)")
    void tc05_vo2Max_max() {
        HealthIndexScore h = new HealthIndexScore(100.0, NOM_RHR, NOM_HRR);
        assertEquals(5, h.calculateVo2MaxScore());
        assertEquals(11, h.getTotalScore());
    }

    @Test
    @DisplayName("TC06: RHR = MIN (40)")
    void tc06_rhr_min() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, 40, NOM_HRR);
        assertEquals(5, h.calculateRhrScore());
        assertEquals(10, h.getTotalScore());
    }

    @Test
    @DisplayName("TC07: RHR = MIN+ (41)")
    void tc07_rhr_minPlus() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, 41, NOM_HRR);
        assertEquals(5, h.calculateRhrScore());
        assertEquals(10, h.getTotalScore());
    }

    @Test
    @DisplayName("TC08: RHR = MAX- (219)")
    void tc08_rhr_maxMinus() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, 219, NOM_HRR);
        assertEquals(1, h.calculateRhrScore());
        assertEquals(6, h.getTotalScore());
    }

    @Test
    @DisplayName("TC09: RHR = MAX (220)")
    void tc09_rhr_max() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, 220, NOM_HRR);
        assertEquals(1, h.calculateRhrScore());
        assertEquals(6, h.getTotalScore());
    }

    @Test
    @DisplayName("TC10: HRR = MIN (0)")
    void tc10_hrr_min() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, NOM_RHR, 0);
        assertEquals(1, h.calculateHrrScore());
        assertEquals(6, h.getTotalScore());
    }

    @Test
    @DisplayName("TC11: HRR = MIN+ (1)")
    void tc11_hrr_minPlus() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, NOM_RHR, 1);
        assertEquals(1, h.calculateHrrScore());
        assertEquals(6, h.getTotalScore());
    }

    @Test
    @DisplayName("TC12: HRR = MAX- (49)")
    void tc12_hrr_maxMinus() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, NOM_RHR, 49);
        assertEquals(5, h.calculateHrrScore());
        assertEquals(10, h.getTotalScore());
    }

    @Test
    @DisplayName("TC13: HRR = MAX (50)")
    void tc13_hrr_max() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, NOM_RHR, 50);
        assertEquals(5, h.calculateHrrScore());
        assertEquals(10, h.getTotalScore());
    }

    // =========================================================
    // Part B - Robustness (invalid) points: MIN-1 and MAX+1
    // =========================================================

    @Test
    @DisplayName("TC14: VO2Max = MIN-1 (-1) -> invalid, expect exception")
    void tc14_vo2Max_belowMin() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new HealthIndexScore(-1.0, NOM_RHR, NOM_HRR));
        assertTrue(ex.getMessage().contains("VO2 Max"));
    }

    @Test
    @DisplayName("TC15: VO2Max = MAX+1 (101) -> no exception in current code (upper bound not enforced)")
    void tc15_vo2Max_aboveMax() {
        HealthIndexScore h = new HealthIndexScore(101.0, NOM_RHR, NOM_HRR);
        assertEquals(5, h.calculateVo2MaxScore());
        assertEquals(11, h.getTotalScore());
    }

    @Test
    @DisplayName("TC16: RHR = MIN-1 (39) -> invalid, expect exception")
    void tc16_rhr_belowMin() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new HealthIndexScore(NOM_VO2, 39, NOM_HRR));
        assertTrue(ex.getMessage().contains("Resting Heart Rate"));
    }

    @Test
    @DisplayName("TC17: RHR = MAX+1 (221) -> invalid, expect exception")
    void tc17_rhr_aboveMax() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new HealthIndexScore(NOM_VO2, 221, NOM_HRR));
        assertTrue(ex.getMessage().contains("Resting Heart Rate"));
    }

    @Test
    @DisplayName("TC18: HRR = MIN-1 (-1) -> invalid, expect exception")
    void tc18_hrr_belowMin() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new HealthIndexScore(NOM_VO2, NOM_RHR, -1));
        assertTrue(ex.getMessage().contains("Heart Rate Recovery"));
    }

    @Test
    @DisplayName("TC19: HRR = MAX+1 (51) -> no exception in current code (upper bound not enforced)")
    void tc19_hrr_aboveMax() {
        HealthIndexScore h = new HealthIndexScore(NOM_VO2, NOM_RHR, 51);
        assertEquals(5, h.calculateHrrScore());
        assertEquals(10, h.getTotalScore());
    }
}