/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leituradearquivos;

import java.util.ArrayList;

/**
 *
 * @author aline
 */
public class Contract {

    String description, weekendDefinition;
    Boolean singleAssignmentPerDayOn, completeWeekendsOn, ident_ShiftTypesDuringWeekendOn, noNightShiftBeforeFreeWeekendOn, twoFreeDaysAfterNightShiftsOn, alternativeSkillCategoryOn;
    int id, singleAssignmentPerDayWeight, completeWeekendsWeight, ident_ShiftTypesDuringWeekendWeight, noNightShiftBeforeFreeWeekendWeight, twoFreeDaysAfterNightShiftsWeight, alternativeSkillCategoryWeight;

    ArrayList<String> weekend = new ArrayList<>();
    
    Boolean maxNumAssignmentsOn, minNumAssignmentsOn, maxConsecutiveWorkingDaysOn, minConsecutiveWorkingDaysOn, maxConsecutiveFreeDaysOn, minConsecutiveFreeDaysOn, maxConsecutiveWorkingWeekendsOn, minConsecutiveWorkingWeekendsOn, maxWorkingWeekendsInFourWeeksOn;
    int maxNumAssignmentsOnWeight, maxNumAssignmentsOnValue;
    int minNumAssignmentsValue, minNumAssignmentsWeight;
    int maxConsecutiveWorkingDaysWeight, maxConsecutiveWorkingDaysValue;
    int minConsecutiveWorkingDaysWeight, minConsecutiveWorkingDaysValue;
    int maxConsecutiveFreeDaysWeight, maxConsecutiveFreeDaysValue;
    int minConsecutiveFreeDaysWeight, minConsecutiveFreeDaysValue;
    int maxConsecutiveWorkingWeekendsWeight, maxConsecutiveWorkingWeekendsValue;
    int minConsecutiveWorkingWeekendsWeight, minConsecutiveWorkingWeekendsValue;
    int maxWorkingWeekendsInFourWeeksWeight, maxWorkingWeekendsInFourWeeksValue;

    int numberOfUnwantedPatterns;
//    Pattern[] unwantedPatterns;
    int unwantedPatterns;
    ArrayList<Integer> unwantedPatternsId = new ArrayList<Integer>();

    public int getMaxWorkingWeekendsInFourWeeksWeight() {
        return maxWorkingWeekendsInFourWeeksWeight;
    }

    public void setMaxWorkingWeekendsInFourWeeksWeight(int maxWorkingWeekendsInFourWeeksWeight) {
        this.maxWorkingWeekendsInFourWeeksWeight = maxWorkingWeekendsInFourWeeksWeight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeekendDefinition() {
        return weekendDefinition;
    }

    public void setWeekendDefinition(String weekendDefinition) {
        this.weekendDefinition = weekendDefinition;
    }

    public Boolean getSingleAssignmentPerDayOn() {
        return singleAssignmentPerDayOn;
    }

    public void setSingleAssignmentPerDayOn(Boolean singleAssignmentPerDayOn) {
        this.singleAssignmentPerDayOn = singleAssignmentPerDayOn;
    }

    public Boolean getCompleteWeekendsOn() {
        return completeWeekendsOn;
    }

    public void setCompleteWeekendsOn(Boolean completeWeekendsOn) {
        this.completeWeekendsOn = completeWeekendsOn;
    }

    public Boolean getIdent_ShiftTypesDuringWeekendOn() {
        return ident_ShiftTypesDuringWeekendOn;
    }

    public void setIdent_ShiftTypesDuringWeekendOn(Boolean ident_ShiftTypesDuringWeekendOn) {
        this.ident_ShiftTypesDuringWeekendOn = ident_ShiftTypesDuringWeekendOn;
    }

    public Boolean getNoNightShiftBeforeFreeWeekendOn() {
        return noNightShiftBeforeFreeWeekendOn;
    }

    public void setNoNightShiftBeforeFreeWeekendOn(Boolean noNightShiftBeforeFreeWeekendOn) {
        this.noNightShiftBeforeFreeWeekendOn = noNightShiftBeforeFreeWeekendOn;
    }

    public Boolean getTwoFreeDaysAfterNightShiftsOn() {
        return twoFreeDaysAfterNightShiftsOn;
    }

    public void setTwoFreeDaysAfterNightShiftsOn(Boolean twoFreeDaysAfterNightShiftsOn) {
        this.twoFreeDaysAfterNightShiftsOn = twoFreeDaysAfterNightShiftsOn;
    }

    public Boolean getAlternativeSkillCategoryOn() {
        return alternativeSkillCategoryOn;
    }

    public void setAlternativeSkillCategoryOn(Boolean alternativeSkillCategoryOn) {
        this.alternativeSkillCategoryOn = alternativeSkillCategoryOn;
    }

    public int getSingleAssignmentPerDayWeight() {
        return singleAssignmentPerDayWeight;
    }

    public void setSingleAssignmentPerDayWeight(int singleAssignmentPerDayWeight) {
        this.singleAssignmentPerDayWeight = singleAssignmentPerDayWeight;
    }

    public int getCompleteWeekendsWeight() {
        return completeWeekendsWeight;
    }

    public void setCompleteWeekendsWeight(int completeWeekendsWeight) {
        this.completeWeekendsWeight = completeWeekendsWeight;
    }

    public int getIdent_ShiftTypesDuringWeekendWeight() {
        return ident_ShiftTypesDuringWeekendWeight;
    }

    public void setIdent_ShiftTypesDuringWeekendWeight(int ident_ShiftTypesDuringWeekendWeight) {
        this.ident_ShiftTypesDuringWeekendWeight = ident_ShiftTypesDuringWeekendWeight;
    }

    public int getNoNightShiftBeforeFreeWeekendWeight() {
        return noNightShiftBeforeFreeWeekendWeight;
    }

    public void setNoNightShiftBeforeFreeWeekendWeight(int noNightShiftBeforeFreeWeekendWeight) {
        this.noNightShiftBeforeFreeWeekendWeight = noNightShiftBeforeFreeWeekendWeight;
    }

    public int getTwoFreeDaysAfterNightShiftsWeight() {
        return twoFreeDaysAfterNightShiftsWeight;
    }

    public void setTwoFreeDaysAfterNightShiftsWeight(int twoFreeDaysAfterNightShiftsWeight) {
        this.twoFreeDaysAfterNightShiftsWeight = twoFreeDaysAfterNightShiftsWeight;
    }

    public int getAlternativeSkillCategoryWeight() {
        return alternativeSkillCategoryWeight;
    }

    public void setAlternativeSkillCategoryWeight(int alternativeSkillCategoryWeight) {
        this.alternativeSkillCategoryWeight = alternativeSkillCategoryWeight;
    }

    public Boolean getMaxNumAssignmentsOn() {
        return maxNumAssignmentsOn;
    }

    public void setMaxNumAssignmentsOn(Boolean maxNumAssignmentsOn) {
        this.maxNumAssignmentsOn = maxNumAssignmentsOn;
    }

    public Boolean getMinNumAssignmentsOn() {
        return minNumAssignmentsOn;
    }

    public void setMinNumAssignmentsOn(Boolean minNumAssignmentsOn) {
        this.minNumAssignmentsOn = minNumAssignmentsOn;
    }

    public Boolean getMaxConsecutiveWorkingDaysOn() {
        return maxConsecutiveWorkingDaysOn;
    }

    public void setMaxConsecutiveWorkingDaysOn(Boolean maxConsecutiveWorkingDaysOn) {
        this.maxConsecutiveWorkingDaysOn = maxConsecutiveWorkingDaysOn;
    }

    public Boolean getMinConsecutiveWorkingDaysOn() {
        return minConsecutiveWorkingDaysOn;
    }

    public void setMinConsecutiveWorkingDaysOn(Boolean minConsecutiveWorkingDaysOn) {
        this.minConsecutiveWorkingDaysOn = minConsecutiveWorkingDaysOn;
    }

    public Boolean getMaxConsecutiveFreeDaysOn() {
        return maxConsecutiveFreeDaysOn;
    }

    public void setMaxConsecutiveFreeDaysOn(Boolean maxConsecutiveFreeDaysOn) {
        this.maxConsecutiveFreeDaysOn = maxConsecutiveFreeDaysOn;
    }

    public Boolean getMinConsecutiveFreeDaysOn() {
        return minConsecutiveFreeDaysOn;
    }

    public void setMinConsecutiveFreeDaysOn(Boolean minConsecutiveFreeDaysOn) {
        this.minConsecutiveFreeDaysOn = minConsecutiveFreeDaysOn;
    }

    public Boolean getMaxConsecutiveWorkingWeekendsOn() {
        return maxConsecutiveWorkingWeekendsOn;
    }

    public void setMaxConsecutiveWorkingWeekendsOn(Boolean maxConsecutiveWorkingWeekendsOn) {
        this.maxConsecutiveWorkingWeekendsOn = maxConsecutiveWorkingWeekendsOn;
    }

    public Boolean getMinConsecutiveWorkingWeekendsOn() {
        return minConsecutiveWorkingWeekendsOn;
    }

    public void setMinConsecutiveWorkingWeekendsOn(Boolean minConsecutiveWorkingWeekendsOn) {
        this.minConsecutiveWorkingWeekendsOn = minConsecutiveWorkingWeekendsOn;
    }

    public Boolean getMaxWorkingWeekendsInFourWeeksOn() {
        return maxWorkingWeekendsInFourWeeksOn;
    }

    public void setMaxWorkingWeekendsInFourWeeksOn(Boolean maxWorkingWeekendsInFourWeeksOn) {
        this.maxWorkingWeekendsInFourWeeksOn = maxWorkingWeekendsInFourWeeksOn;
    }

    public int getMaxNumAssignmentsOnWeight() {
        return maxNumAssignmentsOnWeight;
    }

    public void setMaxNumAssignmentsOnWeight(int maxNumAssignmentsOnWeight) {
        this.maxNumAssignmentsOnWeight = maxNumAssignmentsOnWeight;
    }

    public int getMaxNumAssignmentsOnValue() {
        return maxNumAssignmentsOnValue;
    }

    public void setMaxNumAssignmentsOnValue(int maxNumAssignmentsOnValue) {
        this.maxNumAssignmentsOnValue = maxNumAssignmentsOnValue;
    }

    public int getMinNumAssignmentsValue() {
        return minNumAssignmentsValue;
    }

    public void setMinNumAssignmentsValue(int minNumAssignmentsValue) {
        this.minNumAssignmentsValue = minNumAssignmentsValue;
    }

    public int getMinNumAssignmentsWeight() {
        return minNumAssignmentsWeight;
    }

    public void setMinNumAssignmentsWeight(int minNumAssignmentsWeight) {
        this.minNumAssignmentsWeight = minNumAssignmentsWeight;
    }

    public int getMaxConsecutiveWorkingDaysWeight() {
        return maxConsecutiveWorkingDaysWeight;
    }

    public void setMaxConsecutiveWorkingDaysWeight(int maxConsecutiveWorkingDaysWeight) {
        this.maxConsecutiveWorkingDaysWeight = maxConsecutiveWorkingDaysWeight;
    }

    public int getMaxConsecutiveWorkingDaysValue() {
        return maxConsecutiveWorkingDaysValue;
    }

    public void setMaxConsecutiveWorkingDaysValue(int maxConsecutiveWorkingDaysValue) {
        this.maxConsecutiveWorkingDaysValue = maxConsecutiveWorkingDaysValue;
    }

    public int getMinConsecutiveWorkingDaysWeight() {
        return minConsecutiveWorkingDaysWeight;
    }

    public void setMinConsecutiveWorkingDaysWeight(int minConsecutiveWorkingDaysWeight) {
        this.minConsecutiveWorkingDaysWeight = minConsecutiveWorkingDaysWeight;
    }

    public int getMinConsecutiveWorkingDaysValue() {
        return minConsecutiveWorkingDaysValue;
    }

    public void setMinConsecutiveWorkingDaysValue(int minConsecutiveWorkingDaysValue) {
        this.minConsecutiveWorkingDaysValue = minConsecutiveWorkingDaysValue;
    }

    public int getMaxConsecutiveFreeDaysWeight() {
        return maxConsecutiveFreeDaysWeight;
    }

    public void setMaxConsecutiveFreeDaysWeight(int maxConsecutiveFreeDaysWeight) {
        this.maxConsecutiveFreeDaysWeight = maxConsecutiveFreeDaysWeight;
    }

    public int getMaxConsecutiveFreeDaysValue() {
        return maxConsecutiveFreeDaysValue;
    }

    public void setMaxConsecutiveFreeDaysValue(int maxConsecutiveFreeDaysValue) {
        this.maxConsecutiveFreeDaysValue = maxConsecutiveFreeDaysValue;
    }

    public int getMinConsecutiveFreeDaysWeight() {
        return minConsecutiveFreeDaysWeight;
    }

    public void setMinConsecutiveFreeDaysWeight(int minConsecutiveFreeDaysWeight) {
        this.minConsecutiveFreeDaysWeight = minConsecutiveFreeDaysWeight;
    }

    public int getMinConsecutiveFreeDaysValue() {
        return minConsecutiveFreeDaysValue;
    }

    public void setMinConsecutiveFreeDaysValue(int minConsecutiveFreeDaysValue) {
        this.minConsecutiveFreeDaysValue = minConsecutiveFreeDaysValue;
    }

    public int getMaxConsecutiveWorkingWeekendsWeight() {
        return maxConsecutiveWorkingWeekendsWeight;
    }

    public void setMaxConsecutiveWorkingWeekendsWeight(int maxConsecutiveWorkingWeekendsWeight) {
        this.maxConsecutiveWorkingWeekendsWeight = maxConsecutiveWorkingWeekendsWeight;
    }

    public int getMaxConsecutiveWorkingWeekendsValue() {
        return maxConsecutiveWorkingWeekendsValue;
    }

    public void setMaxConsecutiveWorkingWeekendsValue(int maxConsecutiveWorkingWeekendsValue) {
        this.maxConsecutiveWorkingWeekendsValue = maxConsecutiveWorkingWeekendsValue;
    }

    public int getMinConsecutiveWorkingWeekendsWeight() {
        return minConsecutiveWorkingWeekendsWeight;
    }

    public void setMinConsecutiveWorkingWeekendsWeight(int minConsecutiveWorkingWeekendsWeight) {
        this.minConsecutiveWorkingWeekendsWeight = minConsecutiveWorkingWeekendsWeight;
    }

    public int getMinConsecutiveWorkingWeekendsValue() {
        return minConsecutiveWorkingWeekendsValue;
    }

    public void setMinConsecutiveWorkingWeekendsValue(int minConsecutiveWorkingWeekendsValue) {
        this.minConsecutiveWorkingWeekendsValue = minConsecutiveWorkingWeekendsValue;
    }

    public int getMaxWorkingWeekendsInFourWeeksValue() {
        return maxWorkingWeekendsInFourWeeksValue;
    }

    public void setMaxWorkingWeekendsInFourWeeksValue(int maxWorkingWeekendsInFourWeeksValue) {
        this.maxWorkingWeekendsInFourWeeksValue = maxWorkingWeekendsInFourWeeksValue;
    }

    public int getNumberOfUnwantedPatterns() {
        return numberOfUnwantedPatterns;
    }

    public void setNumberOfUnwantedPatterns(int numberOfUnwantedPatterns) {
        this.numberOfUnwantedPatterns = numberOfUnwantedPatterns;
    }

    public int getUnwantedPatterns() {
        return unwantedPatterns;
    }

    public void setUnwantedPatterns(int unwantedPatterns) {
        this.unwantedPatterns = unwantedPatterns;
    }

    public ArrayList<Integer> getUnwantedPatternsId() {
        return unwantedPatternsId;
    }

    public void setUnwantedPatternsId(ArrayList<Integer> unwantedPatternsId) {
        this.unwantedPatternsId = unwantedPatternsId;
    }

    public ArrayList<String> getWeekend() {
        return weekend;
    }

    public void setWeekend(ArrayList<String> weekend) {
        this.weekend = weekend;
    }

    


}
