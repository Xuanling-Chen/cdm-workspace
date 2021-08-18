package cdm.legalagreement.master;

import cdm.legalagreement.common.AddressForNotices;
import cdm.legalagreement.master.meta.MasterAgreementScheduleMeta;
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
 * The set of elections which specify a Master Agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface MasterAgreementSchedule extends RosettaModelObject {
	MasterAgreementSchedule build();
	MasterAgreementSchedule.MasterAgreementScheduleBuilder toBuilder();
	
	/**
	 * Specification of the address and other details for notices.
	 */
	AddressForNotices getAddressForNotices();
	/**
	 * The specification of whether there is an automatic occurrence of an Early Termination Date in respect of Transactions upon the occurrence of certain bankruptcy / insolvency related events.
	 */
	AutomaticEarlyTermination getAutomaticEarlyTermination();
	/**
	 * Identification of party specific Credit Support Documents applicable to the document.
	 */
	CreditSupportDocument getCreditSupportDocument();
	/**
	 * Identification of party specific Credit Support Providers applicable to the document.
	 */
	CreditSupportProvider getCreditSupportProvider();
	/**
	 * Specification of whether the Governing Law clause extends to Non-Contractual Obligations (True) or does not extend to Non-Contractual Obligations (False).
	 */
	Boolean getNonContractualObligations();
	/**
	 * A provision that allows each party to specify its Specified Entities for certain Events of Default and Termination Events
	 */
	List<? extends SpecifiedEntities> getSpecifiedEntities();
	/**
	 * Specification of the currency in which the termination payment is made (including the process by which such currency is determined).
	 */
	TerminationCurrency getTerminationCurrency();
	final static MasterAgreementScheduleMeta metaData = new MasterAgreementScheduleMeta();
	
	@Override
	default RosettaMetaData<? extends MasterAgreementSchedule> metaData() {
		return metaData;
	} 
			
	static MasterAgreementSchedule.MasterAgreementScheduleBuilder builder() {
		return new MasterAgreementSchedule.MasterAgreementScheduleBuilderImpl();
	}
	
	default Class<? extends MasterAgreementSchedule> getType() {
		return MasterAgreementSchedule.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("nonContractualObligations"), Boolean.class, getNonContractualObligations(), this);
		
		processRosetta(path.newSubPath("addressForNotices"), processor, AddressForNotices.class, getAddressForNotices());
		processRosetta(path.newSubPath("automaticEarlyTermination"), processor, AutomaticEarlyTermination.class, getAutomaticEarlyTermination());
		processRosetta(path.newSubPath("creditSupportDocument"), processor, CreditSupportDocument.class, getCreditSupportDocument());
		processRosetta(path.newSubPath("creditSupportProvider"), processor, CreditSupportProvider.class, getCreditSupportProvider());
		processRosetta(path.newSubPath("specifiedEntities"), processor, SpecifiedEntities.class, getSpecifiedEntities());
		processRosetta(path.newSubPath("terminationCurrency"), processor, TerminationCurrency.class, getTerminationCurrency());
	}
	
	
	interface MasterAgreementScheduleBuilder extends MasterAgreementSchedule, RosettaModelObjectBuilder {
		AddressForNotices.AddressForNoticesBuilder getOrCreateAddressForNotices();
		AddressForNotices.AddressForNoticesBuilder getAddressForNotices();
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder getOrCreateAutomaticEarlyTermination();
		AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder getAutomaticEarlyTermination();
		CreditSupportDocument.CreditSupportDocumentBuilder getOrCreateCreditSupportDocument();
		CreditSupportDocument.CreditSupportDocumentBuilder getCreditSupportDocument();
		CreditSupportProvider.CreditSupportProviderBuilder getOrCreateCreditSupportProvider();
		CreditSupportProvider.CreditSupportProviderBuilder getCreditSupportProvider();
		SpecifiedEntities.SpecifiedEntitiesBuilder getOrCreateSpecifiedEntities(int _index);
		List<? extends SpecifiedEntities.SpecifiedEntitiesBuilder> getSpecifiedEntities();
		TerminationCurrency.TerminationCurrencyBuilder getOrCreateTerminationCurrency();
		TerminationCurrency.TerminationCurrencyBuilder getTerminationCurrency();
		MasterAgreementSchedule.MasterAgreementScheduleBuilder setAddressForNotices(AddressForNotices addressForNotices);
		MasterAgreementSchedule.MasterAgreementScheduleBuilder setAutomaticEarlyTermination(AutomaticEarlyTermination automaticEarlyTermination);
		MasterAgreementSchedule.MasterAgreementScheduleBuilder setCreditSupportDocument(CreditSupportDocument creditSupportDocument);
		MasterAgreementSchedule.MasterAgreementScheduleBuilder setCreditSupportProvider(CreditSupportProvider creditSupportProvider);
		MasterAgreementSchedule.MasterAgreementScheduleBuilder setNonContractualObligations(Boolean nonContractualObligations);
		MasterAgreementSchedule.MasterAgreementScheduleBuilder addSpecifiedEntities(SpecifiedEntities specifiedEntities);
		MasterAgreementSchedule.MasterAgreementScheduleBuilder addSpecifiedEntities(SpecifiedEntities specifiedEntities, int _idx);
		MasterAgreementSchedule.MasterAgreementScheduleBuilder addSpecifiedEntities(List<? extends SpecifiedEntities> specifiedEntities);
		MasterAgreementSchedule.MasterAgreementScheduleBuilder setSpecifiedEntities(List<? extends SpecifiedEntities> specifiedEntities);
		MasterAgreementSchedule.MasterAgreementScheduleBuilder setTerminationCurrency(TerminationCurrency terminationCurrency);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("nonContractualObligations"), Boolean.class, getNonContractualObligations(), this);
			
			processRosetta(path.newSubPath("addressForNotices"), processor, AddressForNotices.AddressForNoticesBuilder.class, getAddressForNotices());
			processRosetta(path.newSubPath("automaticEarlyTermination"), processor, AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder.class, getAutomaticEarlyTermination());
			processRosetta(path.newSubPath("creditSupportDocument"), processor, CreditSupportDocument.CreditSupportDocumentBuilder.class, getCreditSupportDocument());
			processRosetta(path.newSubPath("creditSupportProvider"), processor, CreditSupportProvider.CreditSupportProviderBuilder.class, getCreditSupportProvider());
			processRosetta(path.newSubPath("specifiedEntities"), processor, SpecifiedEntities.SpecifiedEntitiesBuilder.class, getSpecifiedEntities());
			processRosetta(path.newSubPath("terminationCurrency"), processor, TerminationCurrency.TerminationCurrencyBuilder.class, getTerminationCurrency());
		}
		
	}
	
	//MasterAgreementSchedule.MasterAgreementScheduleImpl
	class MasterAgreementScheduleImpl implements MasterAgreementSchedule {
		private final AddressForNotices addressForNotices;
		private final AutomaticEarlyTermination automaticEarlyTermination;
		private final CreditSupportDocument creditSupportDocument;
		private final CreditSupportProvider creditSupportProvider;
		private final Boolean nonContractualObligations;
		private final List<? extends SpecifiedEntities> specifiedEntities;
		private final TerminationCurrency terminationCurrency;
		
		protected MasterAgreementScheduleImpl(MasterAgreementSchedule.MasterAgreementScheduleBuilder builder) {
			this.addressForNotices = ofNullable(builder.getAddressForNotices()).map(f->f.build()).orElse(null);
			this.automaticEarlyTermination = ofNullable(builder.getAutomaticEarlyTermination()).map(f->f.build()).orElse(null);
			this.creditSupportDocument = ofNullable(builder.getCreditSupportDocument()).map(f->f.build()).orElse(null);
			this.creditSupportProvider = ofNullable(builder.getCreditSupportProvider()).map(f->f.build()).orElse(null);
			this.nonContractualObligations = builder.getNonContractualObligations();
			this.specifiedEntities = ofNullable(builder.getSpecifiedEntities()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.terminationCurrency = ofNullable(builder.getTerminationCurrency()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AddressForNotices getAddressForNotices() {
			return addressForNotices;
		}
		
		@Override
		public AutomaticEarlyTermination getAutomaticEarlyTermination() {
			return automaticEarlyTermination;
		}
		
		@Override
		public CreditSupportDocument getCreditSupportDocument() {
			return creditSupportDocument;
		}
		
		@Override
		public CreditSupportProvider getCreditSupportProvider() {
			return creditSupportProvider;
		}
		
		@Override
		public Boolean getNonContractualObligations() {
			return nonContractualObligations;
		}
		
		@Override
		public List<? extends SpecifiedEntities> getSpecifiedEntities() {
			return specifiedEntities;
		}
		
		@Override
		public TerminationCurrency getTerminationCurrency() {
			return terminationCurrency;
		}
		
		@Override
		public MasterAgreementSchedule build() {
			return this;
		}
		
		@Override
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder toBuilder() {
			MasterAgreementSchedule.MasterAgreementScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MasterAgreementSchedule.MasterAgreementScheduleBuilder builder) {
			ofNullable(getAddressForNotices()).ifPresent(builder::setAddressForNotices);
			ofNullable(getAutomaticEarlyTermination()).ifPresent(builder::setAutomaticEarlyTermination);
			ofNullable(getCreditSupportDocument()).ifPresent(builder::setCreditSupportDocument);
			ofNullable(getCreditSupportProvider()).ifPresent(builder::setCreditSupportProvider);
			ofNullable(getNonContractualObligations()).ifPresent(builder::setNonContractualObligations);
			ofNullable(getSpecifiedEntities()).ifPresent(builder::setSpecifiedEntities);
			ofNullable(getTerminationCurrency()).ifPresent(builder::setTerminationCurrency);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementSchedule _that = getType().cast(o);
		
			if (!Objects.equals(addressForNotices, _that.getAddressForNotices())) return false;
			if (!Objects.equals(automaticEarlyTermination, _that.getAutomaticEarlyTermination())) return false;
			if (!Objects.equals(creditSupportDocument, _that.getCreditSupportDocument())) return false;
			if (!Objects.equals(creditSupportProvider, _that.getCreditSupportProvider())) return false;
			if (!Objects.equals(nonContractualObligations, _that.getNonContractualObligations())) return false;
			if (!ListEquals.listEquals(specifiedEntities, _that.getSpecifiedEntities())) return false;
			if (!Objects.equals(terminationCurrency, _that.getTerminationCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (addressForNotices != null ? addressForNotices.hashCode() : 0);
			_result = 31 * _result + (automaticEarlyTermination != null ? automaticEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (creditSupportDocument != null ? creditSupportDocument.hashCode() : 0);
			_result = 31 * _result + (creditSupportProvider != null ? creditSupportProvider.hashCode() : 0);
			_result = 31 * _result + (nonContractualObligations != null ? nonContractualObligations.hashCode() : 0);
			_result = 31 * _result + (specifiedEntities != null ? specifiedEntities.hashCode() : 0);
			_result = 31 * _result + (terminationCurrency != null ? terminationCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementSchedule {" +
				"addressForNotices=" + this.addressForNotices + ", " +
				"automaticEarlyTermination=" + this.automaticEarlyTermination + ", " +
				"creditSupportDocument=" + this.creditSupportDocument + ", " +
				"creditSupportProvider=" + this.creditSupportProvider + ", " +
				"nonContractualObligations=" + this.nonContractualObligations + ", " +
				"specifiedEntities=" + this.specifiedEntities + ", " +
				"terminationCurrency=" + this.terminationCurrency +
			'}';
		}
	}
	
	//MasterAgreementSchedule.MasterAgreementScheduleBuilderImpl
	class MasterAgreementScheduleBuilderImpl implements MasterAgreementSchedule.MasterAgreementScheduleBuilder {
	
		protected AddressForNotices.AddressForNoticesBuilder addressForNotices;
		protected AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder automaticEarlyTermination;
		protected CreditSupportDocument.CreditSupportDocumentBuilder creditSupportDocument;
		protected CreditSupportProvider.CreditSupportProviderBuilder creditSupportProvider;
		protected Boolean nonContractualObligations;
		protected List<SpecifiedEntities.SpecifiedEntitiesBuilder> specifiedEntities = new ArrayList<>();
		protected TerminationCurrency.TerminationCurrencyBuilder terminationCurrency;
	
		public MasterAgreementScheduleBuilderImpl() {
		}
	
		@Override
		public AddressForNotices.AddressForNoticesBuilder getAddressForNotices() {
			return addressForNotices;
		}
		
		@Override
		public AddressForNotices.AddressForNoticesBuilder getOrCreateAddressForNotices() {
			AddressForNotices.AddressForNoticesBuilder result;
			if (addressForNotices!=null) {
				result = addressForNotices;
			}
			else {
				result = addressForNotices = AddressForNotices.builder();
			}
			
			return result;
		}
		
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder getAutomaticEarlyTermination() {
			return automaticEarlyTermination;
		}
		
		@Override
		public AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder getOrCreateAutomaticEarlyTermination() {
			AutomaticEarlyTermination.AutomaticEarlyTerminationBuilder result;
			if (automaticEarlyTermination!=null) {
				result = automaticEarlyTermination;
			}
			else {
				result = automaticEarlyTermination = AutomaticEarlyTermination.builder();
			}
			
			return result;
		}
		
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder getCreditSupportDocument() {
			return creditSupportDocument;
		}
		
		@Override
		public CreditSupportDocument.CreditSupportDocumentBuilder getOrCreateCreditSupportDocument() {
			CreditSupportDocument.CreditSupportDocumentBuilder result;
			if (creditSupportDocument!=null) {
				result = creditSupportDocument;
			}
			else {
				result = creditSupportDocument = CreditSupportDocument.builder();
			}
			
			return result;
		}
		
		@Override
		public CreditSupportProvider.CreditSupportProviderBuilder getCreditSupportProvider() {
			return creditSupportProvider;
		}
		
		@Override
		public CreditSupportProvider.CreditSupportProviderBuilder getOrCreateCreditSupportProvider() {
			CreditSupportProvider.CreditSupportProviderBuilder result;
			if (creditSupportProvider!=null) {
				result = creditSupportProvider;
			}
			else {
				result = creditSupportProvider = CreditSupportProvider.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getNonContractualObligations() {
			return nonContractualObligations;
		}
		
		@Override
		public List<? extends SpecifiedEntities.SpecifiedEntitiesBuilder> getSpecifiedEntities() {
			return specifiedEntities;
		}
		
		public SpecifiedEntities.SpecifiedEntitiesBuilder getOrCreateSpecifiedEntities(int _index) {
		
			if (specifiedEntities==null) {
				this.specifiedEntities = new ArrayList<>();
			}
			SpecifiedEntities.SpecifiedEntitiesBuilder result;
			return getIndex(specifiedEntities, _index, () -> {
						SpecifiedEntities.SpecifiedEntitiesBuilder newSpecifiedEntities = SpecifiedEntities.builder();
						return newSpecifiedEntities;
					});
		}
		
		@Override
		public TerminationCurrency.TerminationCurrencyBuilder getTerminationCurrency() {
			return terminationCurrency;
		}
		
		@Override
		public TerminationCurrency.TerminationCurrencyBuilder getOrCreateTerminationCurrency() {
			TerminationCurrency.TerminationCurrencyBuilder result;
			if (terminationCurrency!=null) {
				result = terminationCurrency;
			}
			else {
				result = terminationCurrency = TerminationCurrency.builder();
			}
			
			return result;
		}
		
	
		@Override
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder setAddressForNotices(AddressForNotices addressForNotices) {
			this.addressForNotices = addressForNotices==null?null:addressForNotices.toBuilder();
			return this;
		}
		@Override
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder setAutomaticEarlyTermination(AutomaticEarlyTermination automaticEarlyTermination) {
			this.automaticEarlyTermination = automaticEarlyTermination==null?null:automaticEarlyTermination.toBuilder();
			return this;
		}
		@Override
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder setCreditSupportDocument(CreditSupportDocument creditSupportDocument) {
			this.creditSupportDocument = creditSupportDocument==null?null:creditSupportDocument.toBuilder();
			return this;
		}
		@Override
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder setCreditSupportProvider(CreditSupportProvider creditSupportProvider) {
			this.creditSupportProvider = creditSupportProvider==null?null:creditSupportProvider.toBuilder();
			return this;
		}
		@Override
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder setNonContractualObligations(Boolean nonContractualObligations) {
			this.nonContractualObligations = nonContractualObligations==null?null:nonContractualObligations;
			return this;
		}
		@Override
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder addSpecifiedEntities(SpecifiedEntities specifiedEntities) {
			if (specifiedEntities!=null) this.specifiedEntities.add(specifiedEntities.toBuilder());
			return this;
		}
		
		@Override
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder addSpecifiedEntities(SpecifiedEntities specifiedEntities, int _idx) {
			getIndex(this.specifiedEntities, _idx, () -> specifiedEntities.toBuilder());
			return this;
		}
		@Override 
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder addSpecifiedEntities(List<? extends SpecifiedEntities> specifiedEntitiess) {
			if (specifiedEntitiess != null) {
				for (SpecifiedEntities toAdd : specifiedEntitiess) {
					this.specifiedEntities.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder setSpecifiedEntities(List<? extends SpecifiedEntities> specifiedEntitiess) {
			if (specifiedEntitiess == null)  {
				this.specifiedEntities = new ArrayList<>();
			}
			else {
				this.specifiedEntities = specifiedEntitiess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder setTerminationCurrency(TerminationCurrency terminationCurrency) {
			this.terminationCurrency = terminationCurrency==null?null:terminationCurrency.toBuilder();
			return this;
		}
		
		@Override
		public MasterAgreementSchedule build() {
			return new MasterAgreementSchedule.MasterAgreementScheduleImpl(this);
		}
		
		@Override
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder prune() {
			if (addressForNotices!=null && !addressForNotices.prune().hasData()) addressForNotices = null;
			if (automaticEarlyTermination!=null && !automaticEarlyTermination.prune().hasData()) automaticEarlyTermination = null;
			if (creditSupportDocument!=null && !creditSupportDocument.prune().hasData()) creditSupportDocument = null;
			if (creditSupportProvider!=null && !creditSupportProvider.prune().hasData()) creditSupportProvider = null;
			specifiedEntities = specifiedEntities.stream().filter(b->b!=null).<SpecifiedEntities.SpecifiedEntitiesBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (terminationCurrency!=null && !terminationCurrency.prune().hasData()) terminationCurrency = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAddressForNotices()!=null && getAddressForNotices().hasData()) return true;
			if (getAutomaticEarlyTermination()!=null && getAutomaticEarlyTermination().hasData()) return true;
			if (getCreditSupportDocument()!=null && getCreditSupportDocument().hasData()) return true;
			if (getCreditSupportProvider()!=null && getCreditSupportProvider().hasData()) return true;
			if (getNonContractualObligations()!=null) return true;
			if (getSpecifiedEntities()!=null && getSpecifiedEntities().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTerminationCurrency()!=null && getTerminationCurrency().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MasterAgreementSchedule.MasterAgreementScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MasterAgreementSchedule.MasterAgreementScheduleBuilder o = (MasterAgreementSchedule.MasterAgreementScheduleBuilder) other;
			
			merger.mergeRosetta(getAddressForNotices(), o.getAddressForNotices(), this::setAddressForNotices);
			merger.mergeRosetta(getAutomaticEarlyTermination(), o.getAutomaticEarlyTermination(), this::setAutomaticEarlyTermination);
			merger.mergeRosetta(getCreditSupportDocument(), o.getCreditSupportDocument(), this::setCreditSupportDocument);
			merger.mergeRosetta(getCreditSupportProvider(), o.getCreditSupportProvider(), this::setCreditSupportProvider);
			merger.mergeRosetta(getSpecifiedEntities(), o.getSpecifiedEntities(), this::getOrCreateSpecifiedEntities);
			merger.mergeRosetta(getTerminationCurrency(), o.getTerminationCurrency(), this::setTerminationCurrency);
			
			merger.mergeBasic(getNonContractualObligations(), o.getNonContractualObligations(), this::setNonContractualObligations);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MasterAgreementSchedule _that = getType().cast(o);
		
			if (!Objects.equals(addressForNotices, _that.getAddressForNotices())) return false;
			if (!Objects.equals(automaticEarlyTermination, _that.getAutomaticEarlyTermination())) return false;
			if (!Objects.equals(creditSupportDocument, _that.getCreditSupportDocument())) return false;
			if (!Objects.equals(creditSupportProvider, _that.getCreditSupportProvider())) return false;
			if (!Objects.equals(nonContractualObligations, _that.getNonContractualObligations())) return false;
			if (!ListEquals.listEquals(specifiedEntities, _that.getSpecifiedEntities())) return false;
			if (!Objects.equals(terminationCurrency, _that.getTerminationCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (addressForNotices != null ? addressForNotices.hashCode() : 0);
			_result = 31 * _result + (automaticEarlyTermination != null ? automaticEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (creditSupportDocument != null ? creditSupportDocument.hashCode() : 0);
			_result = 31 * _result + (creditSupportProvider != null ? creditSupportProvider.hashCode() : 0);
			_result = 31 * _result + (nonContractualObligations != null ? nonContractualObligations.hashCode() : 0);
			_result = 31 * _result + (specifiedEntities != null ? specifiedEntities.hashCode() : 0);
			_result = 31 * _result + (terminationCurrency != null ? terminationCurrency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MasterAgreementScheduleBuilder {" +
				"addressForNotices=" + this.addressForNotices + ", " +
				"automaticEarlyTermination=" + this.automaticEarlyTermination + ", " +
				"creditSupportDocument=" + this.creditSupportDocument + ", " +
				"creditSupportProvider=" + this.creditSupportProvider + ", " +
				"nonContractualObligations=" + this.nonContractualObligations + ", " +
				"specifiedEntities=" + this.specifiedEntities + ", " +
				"terminationCurrency=" + this.terminationCurrency +
			'}';
		}
	}
}
