package cdm.base.datetime.functions;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder;
import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.BusinessDayAdjustments;
import cdm.base.datetime.BusinessDayConventionEnum;
import cdm.base.datetime.DayTypeEnum;
import cdm.base.datetime.PeriodEnum;
import cdm.base.datetime.RelativeDateOffset;
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

@ImplementedBy(ConvertToAdjustableOrRelativeDate.ConvertToAdjustableOrRelativeDateDefault.class)
public abstract class ConvertToAdjustableOrRelativeDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param adjustableOrAdjustedOrRelativeDate 
	* @return adjustableOrRelativeDate 
	*/
	public AdjustableOrRelativeDate evaluate(AdjustableOrAdjustedOrRelativeDate adjustableOrAdjustedOrRelativeDate) {
		
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDateHolder = doEvaluate(adjustableOrAdjustedOrRelativeDate);
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate = assignOutput(adjustableOrRelativeDateHolder, adjustableOrAdjustedOrRelativeDate);
		
		if (adjustableOrRelativeDate!=null) objectValidator.validateAndFailOnErorr(AdjustableOrRelativeDate.class, adjustableOrRelativeDate);
		return adjustableOrRelativeDate;
	}
	
	private AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder assignOutput(AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder adjustableOrRelativeDate, AdjustableOrAdjustedOrRelativeDate adjustableOrAdjustedOrRelativeDate) {
		adjustableOrRelativeDate
			.getOrCreateAdjustableDate()
			.setAdjustedDateValue(MapperS.of(adjustableOrAdjustedOrRelativeDate).<FieldWithMetaDate>map("getAdjustedDate", _adjustableOrAdjustedOrRelativeDate -> _adjustableOrAdjustedOrRelativeDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()).get())
		;
		adjustableOrRelativeDate
			.getOrCreateAdjustableDate()
			.setUnadjustedDate(MapperS.of(adjustableOrAdjustedOrRelativeDate).<Date>map("getUnadjustedDate", _adjustableOrAdjustedOrRelativeDate -> _adjustableOrAdjustedOrRelativeDate.getUnadjustedDate()).get())
		;
		adjustableOrRelativeDate
			.getOrCreateAdjustableDate()
			.setDateAdjustments(MapperS.of(adjustableOrAdjustedOrRelativeDate).<BusinessDayAdjustments>map("getDateAdjustments", _adjustableOrAdjustedOrRelativeDate -> _adjustableOrAdjustedOrRelativeDate.getDateAdjustments()).get())
		;
		adjustableOrRelativeDate
			.getOrCreateRelativeDate()
			.setAdjustedDate(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(relativeDate(adjustableOrAdjustedOrRelativeDate).get())).get()) {
						return MapperS.of(relativeDate(adjustableOrAdjustedOrRelativeDate).get()).<Date>map("getAdjustedDate", _relativeDateOffset -> _relativeDateOffset.getAdjustedDate());
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		adjustableOrRelativeDate
			.getOrCreateRelativeDate()
			.setBusinessCenters(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(relativeDate(adjustableOrAdjustedOrRelativeDate).get())).get()) {
						return MapperS.of(relativeDate(adjustableOrAdjustedOrRelativeDate).get()).<BusinessCenters>map("getBusinessCenters", _relativeDateOffset -> _relativeDateOffset.getBusinessCenters());
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		adjustableOrRelativeDate
			.getOrCreateRelativeDate()
			.setBusinessDayConvention(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(relativeDate(adjustableOrAdjustedOrRelativeDate).get())).get()) {
						return MapperS.of(relativeDate(adjustableOrAdjustedOrRelativeDate).get()).<BusinessDayConventionEnum>map("getBusinessDayConvention", _relativeDateOffset -> _relativeDateOffset.getBusinessDayConvention());
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		adjustableOrRelativeDate
			.getOrCreateRelativeDate()
			.setDateRelativeToValue(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(relativeDate(adjustableOrAdjustedOrRelativeDate).get())).get()) {
						return MapperS.of(relativeDate(adjustableOrAdjustedOrRelativeDate).get()).<BasicReferenceWithMetaDate>map("getDateRelativeTo", _relativeDateOffset -> _relativeDateOffset.getDateRelativeTo()).<Date>map("getValue", _f->_f.getValue());
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		adjustableOrRelativeDate
			.getOrCreateRelativeDate()
			.setDayType(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(relativeDate(adjustableOrAdjustedOrRelativeDate).get())).get()) {
						return MapperS.of(relativeDate(adjustableOrAdjustedOrRelativeDate).get()).<DayTypeEnum>map("getDayType", _offset -> _offset.getDayType());
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		adjustableOrRelativeDate
			.getOrCreateRelativeDate()
			.setPeriod(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(relativeDate(adjustableOrAdjustedOrRelativeDate).get())).get()) {
						return MapperS.of(relativeDate(adjustableOrAdjustedOrRelativeDate).get()).<PeriodEnum>map("getPeriod", _period -> _period.getPeriod());
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		adjustableOrRelativeDate
			.getOrCreateRelativeDate()
			.setPeriodMultiplier(com.rosetta.model.lib.mapper.MapperUtils.from(() -> {
			if (exists(MapperS.of(relativeDate(adjustableOrAdjustedOrRelativeDate).get())).get()) {
						return MapperS.of(relativeDate(adjustableOrAdjustedOrRelativeDate).get()).<Integer>map("getPeriodMultiplier", _period -> _period.getPeriodMultiplier());
					}
			else {
						return MapperS.ofNull();
					}
			}).get())
		;
		return adjustableOrRelativeDate;
	}

	protected abstract AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(AdjustableOrAdjustedOrRelativeDate adjustableOrAdjustedOrRelativeDate);
	
	
	protected Mapper<? extends RelativeDateOffset> relativeDate(AdjustableOrAdjustedOrRelativeDate adjustableOrAdjustedOrRelativeDate) {
		return MapperS.of(adjustableOrAdjustedOrRelativeDate).<RelativeDateOffset>map("getRelativeDate", _adjustableOrAdjustedOrRelativeDate -> _adjustableOrAdjustedOrRelativeDate.getRelativeDate());
	}
	public static final class ConvertToAdjustableOrRelativeDateDefault extends ConvertToAdjustableOrRelativeDate {
		@Override
		protected  AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder doEvaluate(AdjustableOrAdjustedOrRelativeDate adjustableOrAdjustedOrRelativeDate) {
			return AdjustableOrRelativeDate.builder();
		}
	}
}
