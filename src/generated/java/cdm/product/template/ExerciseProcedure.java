package cdm.product.template;

import cdm.product.template.meta.ExerciseProcedureMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class describing how notice of exercise should be given. This can be either manual or automatic.
 * @version ${project.version}
 */
@RosettaClass

public interface ExerciseProcedure extends RosettaModelObject {
	ExerciseProcedure build();
	ExerciseProcedure.ExerciseProcedureBuilder toBuilder();
	
	/**
	 * If automatic is specified, then the notional amount of the underlying swap not previously exercised under the swaption will be automatically exercised at the expiration time on the expiration date if at such time the buyer is in-the-money, provided that the difference between the settlement rate and the fixed rate under the relevant underlying swap is not less than the specified threshold rate. The term in-the-money is assumed to have the meaning defining in the 2000 ISDA Definitions, Section 17.4 In-the-money.
	 */
	AutomaticExercise getAutomaticExercise();
	/**
	 * A flag to indicate whether follow-up confirmation of exercise (written or electronic) is required following telephonic notice by the buyer to the seller or seller&#39;s agent.
	 */
	Boolean getFollowUpConfirmation();
	/**
	 * Has the meaning defined as part of the 1997 ISDA Government Bond Option Definitions, section 4.5 Limited Right to Confirm Exercise. If present, (i) the Seller may request the Buyer to confirm its intent if not done on or before the expiration time on the Expiration date (ii) specific rules will apply in relation to the settlement mode.
	 */
	Boolean getLimitedRightToConfirm();
	/**
	 * Specifies that the notice of exercise must be given by the buyer to the seller or seller&#39;s agent.
	 */
	ManualExercise getManualExercise();
	/**
	 * Typically applicable to the physical settlement of bond and convertible bond options. If present, means that the party required to deliver the bonds will divide those to be delivered as notifying party desires to facilitate delivery obligations.
	 */
	Boolean getSplitTicket();
	final static ExerciseProcedureMeta metaData = new ExerciseProcedureMeta();
	
	@Override
	default RosettaMetaData<? extends ExerciseProcedure> metaData() {
		return metaData;
	} 
			
	static ExerciseProcedure.ExerciseProcedureBuilder builder() {
		return new ExerciseProcedure.ExerciseProcedureBuilderImpl();
	}
	
	default Class<? extends ExerciseProcedure> getType() {
		return ExerciseProcedure.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
		processor.processBasic(path.newSubPath("limitedRightToConfirm"), Boolean.class, getLimitedRightToConfirm(), this);
		processor.processBasic(path.newSubPath("splitTicket"), Boolean.class, getSplitTicket(), this);
		
		processRosetta(path.newSubPath("automaticExercise"), processor, AutomaticExercise.class, getAutomaticExercise());
		processRosetta(path.newSubPath("manualExercise"), processor, ManualExercise.class, getManualExercise());
	}
	
	
	interface ExerciseProcedureBuilder extends ExerciseProcedure, RosettaModelObjectBuilder {
		AutomaticExercise.AutomaticExerciseBuilder getOrCreateAutomaticExercise();
		AutomaticExercise.AutomaticExerciseBuilder getAutomaticExercise();
		ManualExercise.ManualExerciseBuilder getOrCreateManualExercise();
		ManualExercise.ManualExerciseBuilder getManualExercise();
		ExerciseProcedure.ExerciseProcedureBuilder setAutomaticExercise(AutomaticExercise automaticExercise);
		ExerciseProcedure.ExerciseProcedureBuilder setFollowUpConfirmation(Boolean followUpConfirmation);
		ExerciseProcedure.ExerciseProcedureBuilder setLimitedRightToConfirm(Boolean limitedRightToConfirm);
		ExerciseProcedure.ExerciseProcedureBuilder setManualExercise(ManualExercise manualExercise);
		ExerciseProcedure.ExerciseProcedureBuilder setSplitTicket(Boolean splitTicket);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("followUpConfirmation"), Boolean.class, getFollowUpConfirmation(), this);
			processor.processBasic(path.newSubPath("limitedRightToConfirm"), Boolean.class, getLimitedRightToConfirm(), this);
			processor.processBasic(path.newSubPath("splitTicket"), Boolean.class, getSplitTicket(), this);
			
			processRosetta(path.newSubPath("automaticExercise"), processor, AutomaticExercise.AutomaticExerciseBuilder.class, getAutomaticExercise());
			processRosetta(path.newSubPath("manualExercise"), processor, ManualExercise.ManualExerciseBuilder.class, getManualExercise());
		}
		
	}
	
	//ExerciseProcedure.ExerciseProcedureImpl
	class ExerciseProcedureImpl implements ExerciseProcedure {
		private final AutomaticExercise automaticExercise;
		private final Boolean followUpConfirmation;
		private final Boolean limitedRightToConfirm;
		private final ManualExercise manualExercise;
		private final Boolean splitTicket;
		
		protected ExerciseProcedureImpl(ExerciseProcedure.ExerciseProcedureBuilder builder) {
			this.automaticExercise = ofNullable(builder.getAutomaticExercise()).map(f->f.build()).orElse(null);
			this.followUpConfirmation = builder.getFollowUpConfirmation();
			this.limitedRightToConfirm = builder.getLimitedRightToConfirm();
			this.manualExercise = ofNullable(builder.getManualExercise()).map(f->f.build()).orElse(null);
			this.splitTicket = builder.getSplitTicket();
		}
		
		@Override
		public AutomaticExercise getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		public Boolean getLimitedRightToConfirm() {
			return limitedRightToConfirm;
		}
		
		@Override
		public ManualExercise getManualExercise() {
			return manualExercise;
		}
		
		@Override
		public Boolean getSplitTicket() {
			return splitTicket;
		}
		
		@Override
		public ExerciseProcedure build() {
			return this;
		}
		
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder toBuilder() {
			ExerciseProcedure.ExerciseProcedureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseProcedure.ExerciseProcedureBuilder builder) {
			ofNullable(getAutomaticExercise()).ifPresent(builder::setAutomaticExercise);
			ofNullable(getFollowUpConfirmation()).ifPresent(builder::setFollowUpConfirmation);
			ofNullable(getLimitedRightToConfirm()).ifPresent(builder::setLimitedRightToConfirm);
			ofNullable(getManualExercise()).ifPresent(builder::setManualExercise);
			ofNullable(getSplitTicket()).ifPresent(builder::setSplitTicket);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseProcedure _that = getType().cast(o);
		
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(limitedRightToConfirm, _that.getLimitedRightToConfirm())) return false;
			if (!Objects.equals(manualExercise, _that.getManualExercise())) return false;
			if (!Objects.equals(splitTicket, _that.getSplitTicket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (limitedRightToConfirm != null ? limitedRightToConfirm.hashCode() : 0);
			_result = 31 * _result + (manualExercise != null ? manualExercise.hashCode() : 0);
			_result = 31 * _result + (splitTicket != null ? splitTicket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseProcedure {" +
				"automaticExercise=" + this.automaticExercise + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"limitedRightToConfirm=" + this.limitedRightToConfirm + ", " +
				"manualExercise=" + this.manualExercise + ", " +
				"splitTicket=" + this.splitTicket +
			'}';
		}
	}
	
	//ExerciseProcedure.ExerciseProcedureBuilderImpl
	class ExerciseProcedureBuilderImpl implements ExerciseProcedure.ExerciseProcedureBuilder {
	
		protected AutomaticExercise.AutomaticExerciseBuilder automaticExercise;
		protected Boolean followUpConfirmation;
		protected Boolean limitedRightToConfirm;
		protected ManualExercise.ManualExerciseBuilder manualExercise;
		protected Boolean splitTicket;
	
		public ExerciseProcedureBuilderImpl() {
		}
	
		@Override
		public AutomaticExercise.AutomaticExerciseBuilder getAutomaticExercise() {
			return automaticExercise;
		}
		
		@Override
		public AutomaticExercise.AutomaticExerciseBuilder getOrCreateAutomaticExercise() {
			AutomaticExercise.AutomaticExerciseBuilder result;
			if (automaticExercise!=null) {
				result = automaticExercise;
			}
			else {
				result = automaticExercise = AutomaticExercise.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getFollowUpConfirmation() {
			return followUpConfirmation;
		}
		
		@Override
		public Boolean getLimitedRightToConfirm() {
			return limitedRightToConfirm;
		}
		
		@Override
		public ManualExercise.ManualExerciseBuilder getManualExercise() {
			return manualExercise;
		}
		
		@Override
		public ManualExercise.ManualExerciseBuilder getOrCreateManualExercise() {
			ManualExercise.ManualExerciseBuilder result;
			if (manualExercise!=null) {
				result = manualExercise;
			}
			else {
				result = manualExercise = ManualExercise.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getSplitTicket() {
			return splitTicket;
		}
		
	
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder setAutomaticExercise(AutomaticExercise automaticExercise) {
			this.automaticExercise = automaticExercise==null?null:automaticExercise.toBuilder();
			return this;
		}
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder setFollowUpConfirmation(Boolean followUpConfirmation) {
			this.followUpConfirmation = followUpConfirmation==null?null:followUpConfirmation;
			return this;
		}
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder setLimitedRightToConfirm(Boolean limitedRightToConfirm) {
			this.limitedRightToConfirm = limitedRightToConfirm==null?null:limitedRightToConfirm;
			return this;
		}
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder setManualExercise(ManualExercise manualExercise) {
			this.manualExercise = manualExercise==null?null:manualExercise.toBuilder();
			return this;
		}
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder setSplitTicket(Boolean splitTicket) {
			this.splitTicket = splitTicket==null?null:splitTicket;
			return this;
		}
		
		@Override
		public ExerciseProcedure build() {
			return new ExerciseProcedure.ExerciseProcedureImpl(this);
		}
		
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder prune() {
			if (automaticExercise!=null && !automaticExercise.prune().hasData()) automaticExercise = null;
			if (manualExercise!=null && !manualExercise.prune().hasData()) manualExercise = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAutomaticExercise()!=null && getAutomaticExercise().hasData()) return true;
			if (getFollowUpConfirmation()!=null) return true;
			if (getLimitedRightToConfirm()!=null) return true;
			if (getManualExercise()!=null && getManualExercise().hasData()) return true;
			if (getSplitTicket()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseProcedure.ExerciseProcedureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExerciseProcedure.ExerciseProcedureBuilder o = (ExerciseProcedure.ExerciseProcedureBuilder) other;
			
			merger.mergeRosetta(getAutomaticExercise(), o.getAutomaticExercise(), this::setAutomaticExercise);
			merger.mergeRosetta(getManualExercise(), o.getManualExercise(), this::setManualExercise);
			
			merger.mergeBasic(getFollowUpConfirmation(), o.getFollowUpConfirmation(), this::setFollowUpConfirmation);
			merger.mergeBasic(getLimitedRightToConfirm(), o.getLimitedRightToConfirm(), this::setLimitedRightToConfirm);
			merger.mergeBasic(getSplitTicket(), o.getSplitTicket(), this::setSplitTicket);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseProcedure _that = getType().cast(o);
		
			if (!Objects.equals(automaticExercise, _that.getAutomaticExercise())) return false;
			if (!Objects.equals(followUpConfirmation, _that.getFollowUpConfirmation())) return false;
			if (!Objects.equals(limitedRightToConfirm, _that.getLimitedRightToConfirm())) return false;
			if (!Objects.equals(manualExercise, _that.getManualExercise())) return false;
			if (!Objects.equals(splitTicket, _that.getSplitTicket())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (automaticExercise != null ? automaticExercise.hashCode() : 0);
			_result = 31 * _result + (followUpConfirmation != null ? followUpConfirmation.hashCode() : 0);
			_result = 31 * _result + (limitedRightToConfirm != null ? limitedRightToConfirm.hashCode() : 0);
			_result = 31 * _result + (manualExercise != null ? manualExercise.hashCode() : 0);
			_result = 31 * _result + (splitTicket != null ? splitTicket.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseProcedureBuilder {" +
				"automaticExercise=" + this.automaticExercise + ", " +
				"followUpConfirmation=" + this.followUpConfirmation + ", " +
				"limitedRightToConfirm=" + this.limitedRightToConfirm + ", " +
				"manualExercise=" + this.manualExercise + ", " +
				"splitTicket=" + this.splitTicket +
			'}';
		}
	}
}
