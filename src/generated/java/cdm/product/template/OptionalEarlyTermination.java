package cdm.product.template;

import cdm.base.staticdata.party.BuyerSeller;
import cdm.observable.asset.CalculationAgent;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.template.meta.OptionalEarlyTerminationMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A data defining:  an early termination provision where either or both parties have the right to exercise.
 * @version ${project.version}
 */
@RosettaClass

public interface OptionalEarlyTermination extends RosettaModelObject {
	OptionalEarlyTermination build();
	OptionalEarlyTermination.OptionalEarlyTerminationBuilder toBuilder();
	
	/**
	 * American exercise. FpML implementations consists in an exercise substitution group.
	 */
	AmericanExercise getAmericanExercise();
	/**
	 * Bermuda exercise. FpML implementations consists in an exercise substitution group.
	 */
	BermudaExercise getBermudaExercise();
	/**
	 * The ISDA Calculation Agent responsible for performing duties associated with an optional early termination.
	 */
	CalculationAgent getCalculationAgent();
	/**
	 * If specified, this means that cash settlement is applicable to the transaction and defines the parameters associated with the cash settlement procedure. If not specified, then physical settlement is applicable.
	 */
	CashSettlementTerms getCashSettlement();
	/**
	 * European exercise. FpML implementations consists in an exercise substitution group.
	 */
	EuropeanExercise getEuropeanExercise();
	/**
	 * Definition of the party to whom notice of exercise should be given.
	 */
	List<? extends ExerciseNotice> getExerciseNotice();
	/**
	 * A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller&#39;s agent.
	 */
	Boolean getFollowUpConfirmation();
	/**
	 * An early termination provision to terminate the trade at fair value where one or both parties have the right to decide on termination.
	 */
	OptionalEarlyTerminationAdjustedDates getOptionalEarlyTerminationAdjustedDates();
	/**
	 * If optional early termination is not available to both parties then this component specifies the buyer and seller of the option. In FpML, this attribute is of type SinglePsrtyOption, which actually consists of the BuyerSeller.model.
	 */
	BuyerSeller getSinglePartyOption();
	final static OptionalEarlyTerminationMeta metaData = new OptionalEarlyTerminationMeta();
	
	@Override
	default RosettaMetaData<? extends OptionalEarlyTermination> metaData() {
		return metaData;
	} 
			
	static OptionalEarlyTermination.OptionalEarlyTerminationBuilder builder() {
		return new OptionalEarlyTermination.OptionalEarlyTerminationBuilderImpl();
	}
	
	default Class<? extends OptionalEarlyTermination> getType() {
		return OptionalEarlyTermination.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
		
		processRosetta(path.newSubPath("americanExercise"), processor, AmericanExercise.class, getAmericanExercise());
		processRosetta(path.newSubPath("bermudaExercise"), processor, BermudaExercise.class, getBermudaExercise());
		processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.class, getCalculationAgent());
		processRosetta(path.newSubPath("cashSettlement"), processor, CashSettlementTerms.class, getCashSettlement());
		processRosetta(path.newSubPath("europeanExercise"), processor, EuropeanExercise.class, getEuropeanExercise());
		processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.class, getExerciseNotice());
		processRosetta(path.newSubPath("optionalEarlyTerminationAdjustedDates"), processor, OptionalEarlyTerminationAdjustedDates.class, getOptionalEarlyTerminationAdjustedDates());
		processRosetta(path.newSubPath("singlePartyOption"), processor, BuyerSeller.class, getSinglePartyOption());
	}
	
	
	interface OptionalEarlyTerminationBuilder extends OptionalEarlyTermination, RosettaModelObjectBuilder {
		AmericanExercise.AmericanExerciseBuilder getOrCreateAmericanExercise();
		AmericanExercise.AmericanExerciseBuilder getAmericanExercise();
		BermudaExercise.BermudaExerciseBuilder getOrCreateBermudaExercise();
		BermudaExercise.BermudaExerciseBuilder getBermudaExercise();
		CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent();
		CalculationAgent.CalculationAgentBuilder getCalculationAgent();
		CashSettlementTerms.CashSettlementTermsBuilder getOrCreateCashSettlement();
		CashSettlementTerms.CashSettlementTermsBuilder getCashSettlement();
		EuropeanExercise.EuropeanExerciseBuilder getOrCreateEuropeanExercise();
		EuropeanExercise.EuropeanExerciseBuilder getEuropeanExercise();
		ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice(int _index);
		List<? extends ExerciseNotice.ExerciseNoticeBuilder> getExerciseNotice();
		OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder getOrCreateOptionalEarlyTerminationAdjustedDates();
		OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder getOptionalEarlyTerminationAdjustedDates();
		BuyerSeller.BuyerSellerBuilder getOrCreateSinglePartyOption();
		BuyerSeller.BuyerSellerBuilder getSinglePartyOption();
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setAmericanExercise(AmericanExercise americanExercise);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setBermudaExercise(BermudaExercise bermudaExercise);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setCalculationAgent(CalculationAgent calculationAgent);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setCashSettlement(CashSettlementTerms cashSettlement);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setEuropeanExercise(EuropeanExercise europeanExercise);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder addExerciseNotice(ExerciseNotice exerciseNotice);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder addExerciseNotice(ExerciseNotice exerciseNotice, int _idx);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder addExerciseNotice(List<? extends ExerciseNotice> exerciseNotice);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setExerciseNotice(List<? extends ExerciseNotice> exerciseNotice);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setFollowUpConfirmation(Boolean followUpConfirmation);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setOptionalEarlyTerminationAdjustedDates(OptionalEarlyTerminationAdjustedDates optionalEarlyTerminationAdjustedDates);
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder setSinglePartyOption(BuyerSeller singlePartyOption);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
			
			processRosetta(path.newSubPath("americanExercise"), processor, AmericanExercise.AmericanExerciseBuilder.class, getAmericanExercise());
			processRosetta(path.newSubPath("bermudaExercise"), processor, BermudaExercise.BermudaExerciseBuilder.class, getBermudaExercise());
			processRosetta(path.newSubPath("calculationAgent"), processor, CalculationAgent.CalculationAgentBuilder.class, getCalculationAgent());
			processRosetta(path.newSubPath("cashSettlement"), processor, CashSettlementTerms.CashSettlementTermsBuilder.class, getCashSettlement());
			processRosetta(path.newSubPath("europeanExercise"), processor, EuropeanExercise.EuropeanExerciseBuilder.class, getEuropeanExercise());
			processRosetta(path.newSubPath("exerciseNotice"), processor, ExerciseNotice.ExerciseNoticeBuilder.class, getExerciseNotice());
			processRosetta(path.newSubPath("optionalEarlyTerminationAdjustedDates"), processor, OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder.class, getOptionalEarlyTerminationAdjustedDates());
			processRosetta(path.newSubPath("singlePartyOption"), processor, BuyerSeller.BuyerSellerBuilder.class, getSinglePartyOption());
		}
		
	}
	
	//OptionalEarlyTermination.OptionalEarlyTerminationImpl
	class OptionalEarlyTerminationImpl implements OptionalEarlyTermination {
		private final AmericanExercise americanExercise;
		private final BermudaExercise bermudaExercise;
		private final CalculationAgent calculationAgent;
		private final CashSettlementTerms cashSettlement;
		private final EuropeanExercise europeanExercise;
		private final List<? extends ExerciseNotice> exerciseNotice;
		private final Boolean followUpConfirmation;
		private final OptionalEarlyTerminationAdjustedDates optionalEarlyTerminationAdjustedDates;
		private final BuyerSeller singlePartyOption;
		
		protected OptionalEarlyTerminationImpl(OptionalEarlyTermination.OptionalEarlyTerminationBuilder builder) {
			this.americanExercise = ofNullable(builder.getAmericanExercise()).map(f->f.build()).orElse(null);
			this.bermudaExercise = ofNullable(builder.getBermudaExercise()).map(f->f.build()).orElse(null);
			this.calculationAgent = ofNullable(builder.getCalculationAgent()).map(f->f.build()).orElse(null);
			this.cashSettlement = ofNullable(builder.getCashSettlement()).map(f->f.build()).orElse(null);
			this.europeanExercise = ofNullable(builder.getEuropeanExercise()).map(f->f.build()).orElse(null);
			this.exerciseNotice = ofNullable(builder.getExerciseNotice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.followUpConfirmation = builder.getFollowUpConfirmation();
			this.optionalEarlyTerminationAdjustedDates = ofNullable(builder.getOptionalEarlyTerminationAdjustedDates()).map(f->f.build()).orElse(null);
			this.singlePartyOption = ofNullable(builder.getSinglePartyOption()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AmericanExercise getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		public BermudaExercise getBermudaExercise() {
			return bermudaExercise;
		}
		
		@Override
		public CalculationAgent getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		public CashSettlementTerms getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public EuropeanExercise getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		public List<? extends ExerciseNotice> getExerciseNotice() {
			return exerciseNotice;
		}
		
		@Override
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		public OptionalEarlyTerminationAdjustedDates getOptionalEarlyTerminationAdjustedDates() {
			return optionalEarlyTerminationAdjustedDates;
		}
		
		@Override
		public BuyerSeller getSinglePartyOption() {
			return singlePartyOption;
		}
		
		@Override
		public OptionalEarlyTermination build() {
			return this;
		}
		
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder toBuilder() {
			OptionalEarlyTermination.OptionalEarlyTerminationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionalEarlyTermination.OptionalEarlyTerminationBuilder builder) {
			ofNullable(getAmericanExercise()).ifPresent(builder::setAmericanExercise);
			ofNullable(getBermudaExercise()).ifPresent(builder::setBermudaExercise);
			ofNullable(getCalculationAgent()).ifPresent(builder::setCalculationAgent);
			ofNullable(getCashSettlement()).ifPresent(builder::setCashSettlement);
			ofNullable(getEuropeanExercise()).ifPresent(builder::setEuropeanExercise);
			ofNullable(getExerciseNotice()).ifPresent(builder::setExerciseNotice);
			ofNullable(getFollowUpConfirmation()).ifPresent(builder::setFollowUpConfirmation);
			ofNullable(getOptionalEarlyTerminationAdjustedDates()).ifPresent(builder::setOptionalEarlyTerminationAdjustedDates);
			ofNullable(getSinglePartyOption()).ifPresent(builder::setSinglePartyOption);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionalEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(bermudaExercise, _that.getBermudaExercise())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!ListEquals.listEquals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(optionalEarlyTerminationAdjustedDates, _that.getOptionalEarlyTerminationAdjustedDates())) return false;
			if (!Objects.equals(singlePartyOption, _that.getSinglePartyOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (bermudaExercise != null ? bermudaExercise.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationAdjustedDates != null ? optionalEarlyTerminationAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (singlePartyOption != null ? singlePartyOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionalEarlyTermination {" +
				"americanExercise=" + this.americanExercise + ", " +
				"bermudaExercise=" + this.bermudaExercise + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"optionalEarlyTerminationAdjustedDates=" + this.optionalEarlyTerminationAdjustedDates + ", " +
				"singlePartyOption=" + this.singlePartyOption +
			'}';
		}
	}
	
	//OptionalEarlyTermination.OptionalEarlyTerminationBuilderImpl
	class OptionalEarlyTerminationBuilderImpl implements OptionalEarlyTermination.OptionalEarlyTerminationBuilder {
	
		protected AmericanExercise.AmericanExerciseBuilder americanExercise;
		protected BermudaExercise.BermudaExerciseBuilder bermudaExercise;
		protected CalculationAgent.CalculationAgentBuilder calculationAgent;
		protected CashSettlementTerms.CashSettlementTermsBuilder cashSettlement;
		protected EuropeanExercise.EuropeanExerciseBuilder europeanExercise;
		protected List<ExerciseNotice.ExerciseNoticeBuilder> exerciseNotice = new ArrayList<>();
		protected Boolean followUpConfirmation;
		protected OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder optionalEarlyTerminationAdjustedDates;
		protected BuyerSeller.BuyerSellerBuilder singlePartyOption;
	
		public OptionalEarlyTerminationBuilderImpl() {
		}
	
		@Override
		public AmericanExercise.AmericanExerciseBuilder getAmericanExercise() {
			return americanExercise;
		}
		
		@Override
		public AmericanExercise.AmericanExerciseBuilder getOrCreateAmericanExercise() {
			AmericanExercise.AmericanExerciseBuilder result;
			if (americanExercise!=null) {
				result = americanExercise;
			}
			else {
				result = americanExercise = AmericanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		public BermudaExercise.BermudaExerciseBuilder getBermudaExercise() {
			return bermudaExercise;
		}
		
		@Override
		public BermudaExercise.BermudaExerciseBuilder getOrCreateBermudaExercise() {
			BermudaExercise.BermudaExerciseBuilder result;
			if (bermudaExercise!=null) {
				result = bermudaExercise;
			}
			else {
				result = bermudaExercise = BermudaExercise.builder();
			}
			
			return result;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder getCalculationAgent() {
			return calculationAgent;
		}
		
		@Override
		public CalculationAgent.CalculationAgentBuilder getOrCreateCalculationAgent() {
			CalculationAgent.CalculationAgentBuilder result;
			if (calculationAgent!=null) {
				result = calculationAgent;
			}
			else {
				result = calculationAgent = CalculationAgent.builder();
			}
			
			return result;
		}
		
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder getCashSettlement() {
			return cashSettlement;
		}
		
		@Override
		public CashSettlementTerms.CashSettlementTermsBuilder getOrCreateCashSettlement() {
			CashSettlementTerms.CashSettlementTermsBuilder result;
			if (cashSettlement!=null) {
				result = cashSettlement;
			}
			else {
				result = cashSettlement = CashSettlementTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder getEuropeanExercise() {
			return europeanExercise;
		}
		
		@Override
		public EuropeanExercise.EuropeanExerciseBuilder getOrCreateEuropeanExercise() {
			EuropeanExercise.EuropeanExerciseBuilder result;
			if (europeanExercise!=null) {
				result = europeanExercise;
			}
			else {
				result = europeanExercise = EuropeanExercise.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends ExerciseNotice.ExerciseNoticeBuilder> getExerciseNotice() {
			return exerciseNotice;
		}
		
		public ExerciseNotice.ExerciseNoticeBuilder getOrCreateExerciseNotice(int _index) {
		
			if (exerciseNotice==null) {
				this.exerciseNotice = new ArrayList<>();
			}
			ExerciseNotice.ExerciseNoticeBuilder result;
			return getIndex(exerciseNotice, _index, () -> {
						ExerciseNotice.ExerciseNoticeBuilder newExerciseNotice = ExerciseNotice.builder();
						return newExerciseNotice;
					});
		}
		
		@Override
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		public OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder getOptionalEarlyTerminationAdjustedDates() {
			return optionalEarlyTerminationAdjustedDates;
		}
		
		@Override
		public OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder getOrCreateOptionalEarlyTerminationAdjustedDates() {
			OptionalEarlyTerminationAdjustedDates.OptionalEarlyTerminationAdjustedDatesBuilder result;
			if (optionalEarlyTerminationAdjustedDates!=null) {
				result = optionalEarlyTerminationAdjustedDates;
			}
			else {
				result = optionalEarlyTerminationAdjustedDates = OptionalEarlyTerminationAdjustedDates.builder();
			}
			
			return result;
		}
		
		@Override
		public BuyerSeller.BuyerSellerBuilder getSinglePartyOption() {
			return singlePartyOption;
		}
		
		@Override
		public BuyerSeller.BuyerSellerBuilder getOrCreateSinglePartyOption() {
			BuyerSeller.BuyerSellerBuilder result;
			if (singlePartyOption!=null) {
				result = singlePartyOption;
			}
			else {
				result = singlePartyOption = BuyerSeller.builder();
			}
			
			return result;
		}
		
	
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setAmericanExercise(AmericanExercise americanExercise) {
			this.americanExercise = americanExercise==null?null:americanExercise.toBuilder();
			return this;
		}
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setBermudaExercise(BermudaExercise bermudaExercise) {
			this.bermudaExercise = bermudaExercise==null?null:bermudaExercise.toBuilder();
			return this;
		}
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setCalculationAgent(CalculationAgent calculationAgent) {
			this.calculationAgent = calculationAgent==null?null:calculationAgent.toBuilder();
			return this;
		}
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setCashSettlement(CashSettlementTerms cashSettlement) {
			this.cashSettlement = cashSettlement==null?null:cashSettlement.toBuilder();
			return this;
		}
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setEuropeanExercise(EuropeanExercise europeanExercise) {
			this.europeanExercise = europeanExercise==null?null:europeanExercise.toBuilder();
			return this;
		}
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder addExerciseNotice(ExerciseNotice exerciseNotice) {
			if (exerciseNotice!=null) this.exerciseNotice.add(exerciseNotice.toBuilder());
			return this;
		}
		
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder addExerciseNotice(ExerciseNotice exerciseNotice, int _idx) {
			getIndex(this.exerciseNotice, _idx, () -> exerciseNotice.toBuilder());
			return this;
		}
		@Override 
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder addExerciseNotice(List<? extends ExerciseNotice> exerciseNotices) {
			if (exerciseNotices != null) {
				for (ExerciseNotice toAdd : exerciseNotices) {
					this.exerciseNotice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setExerciseNotice(List<? extends ExerciseNotice> exerciseNotices) {
			if (exerciseNotices == null)  {
				this.exerciseNotice = new ArrayList<>();
			}
			else {
				this.exerciseNotice = exerciseNotices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setFollowUpConfirmation(Boolean followUpConfirmation) {
			this.followUpConfirmation = followUpConfirmation==null?null:followUpConfirmation;
			return this;
		}
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setOptionalEarlyTerminationAdjustedDates(OptionalEarlyTerminationAdjustedDates optionalEarlyTerminationAdjustedDates) {
			this.optionalEarlyTerminationAdjustedDates = optionalEarlyTerminationAdjustedDates==null?null:optionalEarlyTerminationAdjustedDates.toBuilder();
			return this;
		}
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder setSinglePartyOption(BuyerSeller singlePartyOption) {
			this.singlePartyOption = singlePartyOption==null?null:singlePartyOption.toBuilder();
			return this;
		}
		
		@Override
		public OptionalEarlyTermination build() {
			return new OptionalEarlyTermination.OptionalEarlyTerminationImpl(this);
		}
		
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder prune() {
			if (americanExercise!=null && !americanExercise.prune().hasData()) americanExercise = null;
			if (bermudaExercise!=null && !bermudaExercise.prune().hasData()) bermudaExercise = null;
			if (calculationAgent!=null && !calculationAgent.prune().hasData()) calculationAgent = null;
			if (cashSettlement!=null && !cashSettlement.prune().hasData()) cashSettlement = null;
			if (europeanExercise!=null && !europeanExercise.prune().hasData()) europeanExercise = null;
			exerciseNotice = exerciseNotice.stream().filter(b->b!=null).<ExerciseNotice.ExerciseNoticeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (optionalEarlyTerminationAdjustedDates!=null && !optionalEarlyTerminationAdjustedDates.prune().hasData()) optionalEarlyTerminationAdjustedDates = null;
			if (singlePartyOption!=null && !singlePartyOption.prune().hasData()) singlePartyOption = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmericanExercise()!=null && getAmericanExercise().hasData()) return true;
			if (getBermudaExercise()!=null && getBermudaExercise().hasData()) return true;
			if (getCalculationAgent()!=null && getCalculationAgent().hasData()) return true;
			if (getCashSettlement()!=null && getCashSettlement().hasData()) return true;
			if (getEuropeanExercise()!=null && getEuropeanExercise().hasData()) return true;
			if (getExerciseNotice()!=null && getExerciseNotice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getFollowUpConfirmation()!=null) return true;
			if (getOptionalEarlyTerminationAdjustedDates()!=null && getOptionalEarlyTerminationAdjustedDates().hasData()) return true;
			if (getSinglePartyOption()!=null && getSinglePartyOption().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionalEarlyTermination.OptionalEarlyTerminationBuilder o = (OptionalEarlyTermination.OptionalEarlyTerminationBuilder) other;
			
			merger.mergeRosetta(getAmericanExercise(), o.getAmericanExercise(), this::setAmericanExercise);
			merger.mergeRosetta(getBermudaExercise(), o.getBermudaExercise(), this::setBermudaExercise);
			merger.mergeRosetta(getCalculationAgent(), o.getCalculationAgent(), this::setCalculationAgent);
			merger.mergeRosetta(getCashSettlement(), o.getCashSettlement(), this::setCashSettlement);
			merger.mergeRosetta(getEuropeanExercise(), o.getEuropeanExercise(), this::setEuropeanExercise);
			merger.mergeRosetta(getExerciseNotice(), o.getExerciseNotice(), this::getOrCreateExerciseNotice);
			merger.mergeRosetta(getOptionalEarlyTerminationAdjustedDates(), o.getOptionalEarlyTerminationAdjustedDates(), this::setOptionalEarlyTerminationAdjustedDates);
			merger.mergeRosetta(getSinglePartyOption(), o.getSinglePartyOption(), this::setSinglePartyOption);
			
			merger.mergeBasic(getFollowUpConfirmation(), o.getFollowUpConfirmation(), this::setFollowUpConfirmation);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionalEarlyTermination _that = getType().cast(o);
		
			if (!Objects.equals(americanExercise, _that.getAmericanExercise())) return false;
			if (!Objects.equals(bermudaExercise, _that.getBermudaExercise())) return false;
			if (!Objects.equals(calculationAgent, _that.getCalculationAgent())) return false;
			if (!Objects.equals(cashSettlement, _that.getCashSettlement())) return false;
			if (!Objects.equals(europeanExercise, _that.getEuropeanExercise())) return false;
			if (!ListEquals.listEquals(exerciseNotice, _that.getExerciseNotice())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(optionalEarlyTerminationAdjustedDates, _that.getOptionalEarlyTerminationAdjustedDates())) return false;
			if (!Objects.equals(singlePartyOption, _that.getSinglePartyOption())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (americanExercise != null ? americanExercise.hashCode() : 0);
			_result = 31 * _result + (bermudaExercise != null ? bermudaExercise.hashCode() : 0);
			_result = 31 * _result + (calculationAgent != null ? calculationAgent.hashCode() : 0);
			_result = 31 * _result + (cashSettlement != null ? cashSettlement.hashCode() : 0);
			_result = 31 * _result + (europeanExercise != null ? europeanExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseNotice != null ? exerciseNotice.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationAdjustedDates != null ? optionalEarlyTerminationAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (singlePartyOption != null ? singlePartyOption.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionalEarlyTerminationBuilder {" +
				"americanExercise=" + this.americanExercise + ", " +
				"bermudaExercise=" + this.bermudaExercise + ", " +
				"calculationAgent=" + this.calculationAgent + ", " +
				"cashSettlement=" + this.cashSettlement + ", " +
				"europeanExercise=" + this.europeanExercise + ", " +
				"exerciseNotice=" + this.exerciseNotice + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"optionalEarlyTerminationAdjustedDates=" + this.optionalEarlyTerminationAdjustedDates + ", " +
				"singlePartyOption=" + this.singlePartyOption +
			'}';
		}
	}
}
