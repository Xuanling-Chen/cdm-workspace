package cdm.base.datetime.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustedRelativeDateOffset;
import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.BusinessDayAdjustments;
import cdm.base.datetime.BusinessDayConventionEnum;
import cdm.base.datetime.DayTypeEnum;
import cdm.base.datetime.PeriodEnum;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.Mapper;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.metafields.BasicReferenceWithMetaDate;
import com.rosetta.model.metafields.FieldWithMetaDate;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

@ImplementedBy(ConvertToAdjustableOrAdjustedOrRelativeDate.ConvertToAdjustableOrAdjustedOrRelativeDateDefault.class)
public abstract class ConvertToAdjustableOrAdjustedOrRelativeDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param adjustableOrRelativeDate 
	* @return adjustableOrAdjustedOrRelativeDate 
	*/
	public AdjustableOrAdjustedOrRelativeDate evaluate(AdjustableOrRelativeDate adjustableOrRelativeDate) {
		
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder adjustableOrAdjustedOrRelativeDateHolder = doEvaluate(adjustableOrRelativeDate);
		AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder adjustableOrAdjustedOrRelativeDate = assignOutput(adjustableOrAdjustedOrRelativeDateHolder, adjustableOrRelativeDate);
		
		if (adjustableOrAdjustedOrRelativeDate!=null) objectValidator.validateAndFailOnErorr(AdjustableOrAdjustedOrRelativeDate.class, adjustableOrAdjustedOrRelativeDate);
		return adjustableOrAdjustedOrRelativeDate;
	}
	
	private AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder assignOutput(AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder adjustableOrAdjustedOrRelativeDate, AdjustableOrRelativeDate adjustableOrRelativeDate) {
		adjustableOrAdjustedOrRelativeDate
			.setAdjustedDateValue(MapperS.of(adjustableOrRelativeDate).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()).get())
		;
		adjustableOrAdjustedOrRelativeDate
			.setUnadjustedDate(MapperS.of(adjustableOrRelativeDate).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()).get())
		;
		adjustableOrAdjustedOrRelativeDate
			.setDateAdjustments(MapperS.of(adjustableOrRelativeDate).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<BusinessDayAdjustments>map("getDateAdjustments", _adjustableDate -> _adjustableDate.getDateAdjustments()).get())
		;
		adjustableOrAdjustedOrRelativeDate
			.getOrCreateRelativeDate()
			.setAdjustedDate(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(relativeDate(adjustableOrRelativeDate).get())).get()) {
						return MapperS.of(relativeDate(adjustableOrRelativeDate).get()).<Date>map("getAdjustedDate", _relativeDateOffset -> _relativeDateOffset.getAdjustedDate());
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		adjustableOrAdjustedOrRelativeDate
			.getOrCreateRelativeDate()
			.setBusinessCenters(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(relativeDate(adjustableOrRelativeDate).get())).get()) {
						return MapperS.of(relativeDate(adjustableOrRelativeDate).get()).<BusinessCenters>map("getBusinessCenters", _relativeDateOffset -> _relativeDateOffset.getBusinessCenters());
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		adjustableOrAdjustedOrRelativeDate
			.getOrCreateRelativeDate()
			.setBusinessDayConvention(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(relativeDate(adjustableOrRelativeDate).get())).get()) {
						return MapperS.of(relativeDate(adjustableOrRelativeDate).get()).<BusinessDayConventionEnum>map("getBusinessDayConvention", _relativeDateOffset -> _relativeDateOffset.getBusinessDayConvention());
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		adjustableOrAdjustedOrRelativeDate
			.getOrCreateRelativeDate()
			.setDateRelativeToValue(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(relativeDate(adjustableOrRelativeDate).get())).get()) {
						return MapperS.of(relativeDate(adjustableOrRelativeDate).get()).<BasicReferenceWithMetaDate>map("getDateRelativeTo", _relativeDateOffset -> _relativeDateOffset.getDateRelativeTo()).<Date>map("getValue", _f->_f.getValue());
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		adjustableOrAdjustedOrRelativeDate
			.getOrCreateRelativeDate()
			.setDayType(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(relativeDate(adjustableOrRelativeDate).get())).get()) {
						return MapperS.of(relativeDate(adjustableOrRelativeDate).get()).<DayTypeEnum>map("getDayType", _offset -> _offset.getDayType());
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		adjustableOrAdjustedOrRelativeDate
			.getOrCreateRelativeDate()
			.setPeriod(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(relativeDate(adjustableOrRelativeDate).get())).get()) {
						return MapperS.of(relativeDate(adjustableOrRelativeDate).get()).<PeriodEnum>map("getPeriod", _period -> _period.getPeriod());
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		adjustableOrAdjustedOrRelativeDate
			.getOrCreateRelativeDate()
			.setPeriodMultiplier(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(relativeDate(adjustableOrRelativeDate).get())).get()) {
						return MapperS.of(relativeDate(adjustableOrRelativeDate).get()).<Integer>map("getPeriodMultiplier", _period -> _period.getPeriodMultiplier());
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		return adjustableOrAdjustedOrRelativeDate;
	}

	protected abstract AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder doEvaluate(AdjustableOrRelativeDate adjustableOrRelativeDate);
	
	
	protected Mapper<? extends AdjustedRelativeDateOffset> relativeDate(AdjustableOrRelativeDate adjustableOrRelativeDate) {
		return MapperS.of(adjustableOrRelativeDate).<AdjustedRelativeDateOffset>map("getRelativeDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getRelativeDate());
	}
	public static final class ConvertToAdjustableOrAdjustedOrRelativeDateDefault extends ConvertToAdjustableOrAdjustedOrRelativeDate {
		@Override
		protected  AdjustableOrAdjustedOrRelativeDate.AdjustableOrAdjustedOrRelativeDateBuilder doEvaluate(AdjustableOrRelativeDate adjustableOrRelativeDate) {
			return AdjustableOrAdjustedOrRelativeDate.builder();
		}
	}
}
