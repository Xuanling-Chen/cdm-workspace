package cdm.product.asset;

import cdm.base.staticdata.asset.credit.Obligations;
import cdm.observable.event.CreditEvents;
import cdm.product.asset.meta.ProtectionTermsMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the terms for calculating a payout to protect the buyer of the swap in the case of a qualified credit event. These terms include the applicable credit events, the reference obligation, and in the case of a CDS on mortgage-backed securities, the floatingAmountEvents.
 * @version ${project.version}
 */
@RosettaClass

public interface ProtectionTerms extends RosettaModelObject, GlobalKey {
	ProtectionTerms build();
	ProtectionTerms.ProtectionTermsBuilder toBuilder();
	
	/**
	 * Specifies the applicable Credit Events that would trigger a settlement, as specified in the related Confirmation and defined in the ISDA 2014 Credit Definition article IV section 4.1.
	 */
	CreditEvents getCreditEvents();
	/**
	 * This element contains the ISDA terms relating to the floating rate payment events and the implied additional fixed payments, applicable to the credit derivatives transactions on mortgage-backed securities with pay-as-you-go or physical settlement.
	 */
	FloatingAmountEvents getFloatingAmountEvents();
	/**
	 */
	MetaFields getMeta();
	/**
	 * The underlying obligations of the reference entity on which you are buying or selling protection. The credit events Failure to Pay, Obligation Acceleration, Obligation Default, Restructuring, Repudiation/Moratorium are defined with respect to these obligations.
	 */
	Obligations getObligations();
	final static ProtectionTermsMeta metaData = new ProtectionTermsMeta();
	
	@Override
	default RosettaMetaData<? extends ProtectionTerms> metaData() {
		return metaData;
	} 
			
	static ProtectionTerms.ProtectionTermsBuilder builder() {
		return new ProtectionTerms.ProtectionTermsBuilderImpl();
	}
	
	default Class<? extends ProtectionTerms> getType() {
		return ProtectionTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.class, getCreditEvents());
		processRosetta(path.newSubPath("floatingAmountEvents"), processor, FloatingAmountEvents.class, getFloatingAmountEvents());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("obligations"), processor, Obligations.class, getObligations());
	}
	
	
	interface ProtectionTermsBuilder extends ProtectionTerms, RosettaModelObjectBuilder {
		CreditEvents.CreditEventsBuilder getOrCreateCreditEvents();
		CreditEvents.CreditEventsBuilder getCreditEvents();
		FloatingAmountEvents.FloatingAmountEventsBuilder getOrCreateFloatingAmountEvents();
		FloatingAmountEvents.FloatingAmountEventsBuilder getFloatingAmountEvents();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Obligations.ObligationsBuilder getOrCreateObligations();
		Obligations.ObligationsBuilder getObligations();
		ProtectionTerms.ProtectionTermsBuilder setCreditEvents(CreditEvents creditEvents);
		ProtectionTerms.ProtectionTermsBuilder setFloatingAmountEvents(FloatingAmountEvents floatingAmountEvents);
		ProtectionTerms.ProtectionTermsBuilder setMeta(MetaFields meta);
		ProtectionTerms.ProtectionTermsBuilder setObligations(Obligations obligations);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("creditEvents"), processor, CreditEvents.CreditEventsBuilder.class, getCreditEvents());
			processRosetta(path.newSubPath("floatingAmountEvents"), processor, FloatingAmountEvents.FloatingAmountEventsBuilder.class, getFloatingAmountEvents());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("obligations"), processor, Obligations.ObligationsBuilder.class, getObligations());
		}
		
	}
	
	//ProtectionTerms.ProtectionTermsImpl
	class ProtectionTermsImpl implements ProtectionTerms {
		private final CreditEvents creditEvents;
		private final FloatingAmountEvents floatingAmountEvents;
		private final MetaFields meta;
		private final Obligations obligations;
		
		protected ProtectionTermsImpl(ProtectionTerms.ProtectionTermsBuilder builder) {
			this.creditEvents = ofNullable(builder.getCreditEvents()).map(f->f.build()).orElse(null);
			this.floatingAmountEvents = ofNullable(builder.getFloatingAmountEvents()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.obligations = ofNullable(builder.getObligations()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public CreditEvents getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		public FloatingAmountEvents getFloatingAmountEvents() {
			return floatingAmountEvents;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Obligations getObligations() {
			return obligations;
		}
		
		@Override
		public ProtectionTerms build() {
			return this;
		}
		
		@Override
		public ProtectionTerms.ProtectionTermsBuilder toBuilder() {
			ProtectionTerms.ProtectionTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ProtectionTerms.ProtectionTermsBuilder builder) {
			ofNullable(getCreditEvents()).ifPresent(builder::setCreditEvents);
			ofNullable(getFloatingAmountEvents()).ifPresent(builder::setFloatingAmountEvents);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getObligations()).ifPresent(builder::setObligations);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProtectionTerms _that = getType().cast(o);
		
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(floatingAmountEvents, _that.getFloatingAmountEvents())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(obligations, _that.getObligations())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (floatingAmountEvents != null ? floatingAmountEvents.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (obligations != null ? obligations.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProtectionTerms {" +
				"creditEvents=" + this.creditEvents + ", " +
				"floatingAmountEvents=" + this.floatingAmountEvents + ", " +
				"meta=" + this.meta + ", " +
				"obligations=" + this.obligations +
			'}';
		}
	}
	
	//ProtectionTerms.ProtectionTermsBuilderImpl
	class ProtectionTermsBuilderImpl implements ProtectionTerms.ProtectionTermsBuilder, GlobalKeyBuilder {
	
		protected CreditEvents.CreditEventsBuilder creditEvents;
		protected FloatingAmountEvents.FloatingAmountEventsBuilder floatingAmountEvents;
		protected MetaFields.MetaFieldsBuilder meta;
		protected Obligations.ObligationsBuilder obligations;
	
		public ProtectionTermsBuilderImpl() {
		}
	
		@Override
		public CreditEvents.CreditEventsBuilder getCreditEvents() {
			return creditEvents;
		}
		
		@Override
		public CreditEvents.CreditEventsBuilder getOrCreateCreditEvents() {
			CreditEvents.CreditEventsBuilder result;
			if (creditEvents!=null) {
				result = creditEvents;
			}
			else {
				result = creditEvents = CreditEvents.builder();
			}
			
			return result;
		}
		
		@Override
		public FloatingAmountEvents.FloatingAmountEventsBuilder getFloatingAmountEvents() {
			return floatingAmountEvents;
		}
		
		@Override
		public FloatingAmountEvents.FloatingAmountEventsBuilder getOrCreateFloatingAmountEvents() {
			FloatingAmountEvents.FloatingAmountEventsBuilder result;
			if (floatingAmountEvents!=null) {
				result = floatingAmountEvents;
			}
			else {
				result = floatingAmountEvents = FloatingAmountEvents.builder();
			}
			
			return result;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		public Obligations.ObligationsBuilder getObligations() {
			return obligations;
		}
		
		@Override
		public Obligations.ObligationsBuilder getOrCreateObligations() {
			Obligations.ObligationsBuilder result;
			if (obligations!=null) {
				result = obligations;
			}
			else {
				result = obligations = Obligations.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ProtectionTerms.ProtectionTermsBuilder setCreditEvents(CreditEvents creditEvents) {
			this.creditEvents = creditEvents==null?null:creditEvents.toBuilder();
			return this;
		}
		@Override
		public ProtectionTerms.ProtectionTermsBuilder setFloatingAmountEvents(FloatingAmountEvents floatingAmountEvents) {
			this.floatingAmountEvents = floatingAmountEvents==null?null:floatingAmountEvents.toBuilder();
			return this;
		}
		@Override
		public ProtectionTerms.ProtectionTermsBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public ProtectionTerms.ProtectionTermsBuilder setObligations(Obligations obligations) {
			this.obligations = obligations==null?null:obligations.toBuilder();
			return this;
		}
		
		@Override
		public ProtectionTerms build() {
			return new ProtectionTerms.ProtectionTermsImpl(this);
		}
		
		@Override
		public ProtectionTerms.ProtectionTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProtectionTerms.ProtectionTermsBuilder prune() {
			if (creditEvents!=null && !creditEvents.prune().hasData()) creditEvents = null;
			if (floatingAmountEvents!=null && !floatingAmountEvents.prune().hasData()) floatingAmountEvents = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (obligations!=null && !obligations.prune().hasData()) obligations = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditEvents()!=null && getCreditEvents().hasData()) return true;
			if (getFloatingAmountEvents()!=null && getFloatingAmountEvents().hasData()) return true;
			if (getObligations()!=null && getObligations().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ProtectionTerms.ProtectionTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ProtectionTerms.ProtectionTermsBuilder o = (ProtectionTerms.ProtectionTermsBuilder) other;
			
			merger.mergeRosetta(getCreditEvents(), o.getCreditEvents(), this::setCreditEvents);
			merger.mergeRosetta(getFloatingAmountEvents(), o.getFloatingAmountEvents(), this::setFloatingAmountEvents);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getObligations(), o.getObligations(), this::setObligations);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ProtectionTerms _that = getType().cast(o);
		
			if (!Objects.equals(creditEvents, _that.getCreditEvents())) return false;
			if (!Objects.equals(floatingAmountEvents, _that.getFloatingAmountEvents())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(obligations, _that.getObligations())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditEvents != null ? creditEvents.hashCode() : 0);
			_result = 31 * _result + (floatingAmountEvents != null ? floatingAmountEvents.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (obligations != null ? obligations.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ProtectionTermsBuilder {" +
				"creditEvents=" + this.creditEvents + ", " +
				"floatingAmountEvents=" + this.floatingAmountEvents + ", " +
				"meta=" + this.meta + ", " +
				"obligations=" + this.obligations +
			'}';
		}
	}
}
