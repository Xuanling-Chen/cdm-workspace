package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.SecurityProviderRightsEventMeta;
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
 * A class to specify the Pledgor/Obligor/Chargor Rights Event election. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (j): Chargor Rights Event. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (j): Obligor Rights Event. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (j): Pledgor Rights Event.
 * @version ${project.version}
 */
@RosettaClass

public interface SecurityProviderRightsEvent extends RosettaModelObject {
	SecurityProviderRightsEvent build();
	SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder toBuilder();
	
	/**
	 * The Automatic Set-Off provision applies when the value is set to True. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (l): Modification to Obligor’s Rights and Remedies.
	 */
	Boolean getAutomaticSetOff();
	/**
	 * A custom Pledgor/Obligor/Chargor Rights Event election might be specified by the parties.
	 */
	String getCustomElection();
	/**
	 * If specified as applicable here, a Pledgor/Obligor/Chargor Rights Event will not occur unless the Pledgor/Obligor/Chargor (A) has provided a statement to the Secured Party in respect of such Early 											Termination Date
	 */
	Boolean getFullDischarge();
	/**
	 * The Pledgor/Obligor/Chargor Rights Event election includes cooling off language when the attribute is set of True.
	 */
	Boolean getIncludeCoolingOffLanguage();
	/**
	 */
	List<? extends SecurityProviderRightsEventElection> getPartyElection();
	final static SecurityProviderRightsEventMeta metaData = new SecurityProviderRightsEventMeta();
	
	@Override
	default RosettaMetaData<? extends SecurityProviderRightsEvent> metaData() {
		return metaData;
	} 
			
	static SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder builder() {
		return new SecurityProviderRightsEvent.SecurityProviderRightsEventBuilderImpl();
	}
	
	default Class<? extends SecurityProviderRightsEvent> getType() {
		return SecurityProviderRightsEvent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("automaticSetOff"), Boolean.class, getAutomaticSetOff(), this);
		processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
		processor.processBasic(path.newSubPath("fullDischarge"), Boolean.class, getFullDischarge(), this);
		processor.processBasic(path.newSubPath("includeCoolingOffLanguage"), Boolean.class, getIncludeCoolingOffLanguage(), this);
		
		processRosetta(path.newSubPath("partyElection"), processor, SecurityProviderRightsEventElection.class, getPartyElection());
	}
	
	
	interface SecurityProviderRightsEventBuilder extends SecurityProviderRightsEvent, RosettaModelObjectBuilder {
		SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder getOrCreatePartyElection(int _index);
		List<? extends SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder> getPartyElection();
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setAutomaticSetOff(Boolean automaticSetOff);
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setCustomElection(String customElection);
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setFullDischarge(Boolean fullDischarge);
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setIncludeCoolingOffLanguage(Boolean includeCoolingOffLanguage);
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder addPartyElection(SecurityProviderRightsEventElection partyElection);
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder addPartyElection(SecurityProviderRightsEventElection partyElection, int _idx);
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder addPartyElection(List<? extends SecurityProviderRightsEventElection> partyElection);
		SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setPartyElection(List<? extends SecurityProviderRightsEventElection> partyElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("automaticSetOff"), Boolean.class, getAutomaticSetOff(), this);
			processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
			processor.processBasic(path.newSubPath("fullDischarge"), Boolean.class, getFullDischarge(), this);
			processor.processBasic(path.newSubPath("includeCoolingOffLanguage"), Boolean.class, getIncludeCoolingOffLanguage(), this);
			
			processRosetta(path.newSubPath("partyElection"), processor, SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder.class, getPartyElection());
		}
		
	}
	
	//SecurityProviderRightsEvent.SecurityProviderRightsEventImpl
	class SecurityProviderRightsEventImpl implements SecurityProviderRightsEvent {
		private final Boolean automaticSetOff;
		private final String customElection;
		private final Boolean fullDischarge;
		private final Boolean includeCoolingOffLanguage;
		private final List<? extends SecurityProviderRightsEventElection> partyElection;
		
		protected SecurityProviderRightsEventImpl(SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder builder) {
			this.automaticSetOff = builder.getAutomaticSetOff();
			this.customElection = builder.getCustomElection();
			this.fullDischarge = builder.getFullDischarge();
			this.includeCoolingOffLanguage = builder.getIncludeCoolingOffLanguage();
			this.partyElection = ofNullable(builder.getPartyElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public Boolean getAutomaticSetOff() {
			return automaticSetOff;
		}
		
		@Override
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public Boolean getFullDischarge() {
			return fullDischarge;
		}
		
		@Override
		public Boolean getIncludeCoolingOffLanguage() {
			return includeCoolingOffLanguage;
		}
		
		@Override
		public List<? extends SecurityProviderRightsEventElection> getPartyElection() {
			return partyElection;
		}
		
		@Override
		public SecurityProviderRightsEvent build() {
			return this;
		}
		
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder toBuilder() {
			SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder builder) {
			ofNullable(getAutomaticSetOff()).ifPresent(builder::setAutomaticSetOff);
			ofNullable(getCustomElection()).ifPresent(builder::setCustomElection);
			ofNullable(getFullDischarge()).ifPresent(builder::setFullDischarge);
			ofNullable(getIncludeCoolingOffLanguage()).ifPresent(builder::setIncludeCoolingOffLanguage);
			ofNullable(getPartyElection()).ifPresent(builder::setPartyElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityProviderRightsEvent _that = getType().cast(o);
		
			if (!Objects.equals(automaticSetOff, _that.getAutomaticSetOff())) return false;
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			if (!Objects.equals(fullDischarge, _that.getFullDischarge())) return false;
			if (!Objects.equals(includeCoolingOffLanguage, _that.getIncludeCoolingOffLanguage())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (automaticSetOff != null ? automaticSetOff.hashCode() : 0);
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			_result = 31 * _result + (fullDischarge != null ? fullDischarge.hashCode() : 0);
			_result = 31 * _result + (includeCoolingOffLanguage != null ? includeCoolingOffLanguage.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityProviderRightsEvent {" +
				"automaticSetOff=" + this.automaticSetOff + ", " +
				"customElection=" + this.customElection + ", " +
				"fullDischarge=" + this.fullDischarge + ", " +
				"includeCoolingOffLanguage=" + this.includeCoolingOffLanguage + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
	
	//SecurityProviderRightsEvent.SecurityProviderRightsEventBuilderImpl
	class SecurityProviderRightsEventBuilderImpl implements SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder {
	
		protected Boolean automaticSetOff;
		protected String customElection;
		protected Boolean fullDischarge;
		protected Boolean includeCoolingOffLanguage;
		protected List<SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder> partyElection = new ArrayList<>();
	
		public SecurityProviderRightsEventBuilderImpl() {
		}
	
		@Override
		public Boolean getAutomaticSetOff() {
			return automaticSetOff;
		}
		
		@Override
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public Boolean getFullDischarge() {
			return fullDischarge;
		}
		
		@Override
		public Boolean getIncludeCoolingOffLanguage() {
			return includeCoolingOffLanguage;
		}
		
		@Override
		public List<? extends SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder> getPartyElection() {
			return partyElection;
		}
		
		public SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder getOrCreatePartyElection(int _index) {
		
			if (partyElection==null) {
				this.partyElection = new ArrayList<>();
			}
			SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder result;
			return getIndex(partyElection, _index, () -> {
						SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder newPartyElection = SecurityProviderRightsEventElection.builder();
						return newPartyElection;
					});
		}
		
	
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setAutomaticSetOff(Boolean automaticSetOff) {
			this.automaticSetOff = automaticSetOff==null?null:automaticSetOff;
			return this;
		}
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setCustomElection(String customElection) {
			this.customElection = customElection==null?null:customElection;
			return this;
		}
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setFullDischarge(Boolean fullDischarge) {
			this.fullDischarge = fullDischarge==null?null:fullDischarge;
			return this;
		}
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setIncludeCoolingOffLanguage(Boolean includeCoolingOffLanguage) {
			this.includeCoolingOffLanguage = includeCoolingOffLanguage==null?null:includeCoolingOffLanguage;
			return this;
		}
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder addPartyElection(SecurityProviderRightsEventElection partyElection) {
			if (partyElection!=null) this.partyElection.add(partyElection.toBuilder());
			return this;
		}
		
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder addPartyElection(SecurityProviderRightsEventElection partyElection, int _idx) {
			getIndex(this.partyElection, _idx, () -> partyElection.toBuilder());
			return this;
		}
		@Override 
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder addPartyElection(List<? extends SecurityProviderRightsEventElection> partyElections) {
			if (partyElections != null) {
				for (SecurityProviderRightsEventElection toAdd : partyElections) {
					this.partyElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder setPartyElection(List<? extends SecurityProviderRightsEventElection> partyElections) {
			if (partyElections == null)  {
				this.partyElection = new ArrayList<>();
			}
			else {
				this.partyElection = partyElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public SecurityProviderRightsEvent build() {
			return new SecurityProviderRightsEvent.SecurityProviderRightsEventImpl(this);
		}
		
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder prune() {
			partyElection = partyElection.stream().filter(b->b!=null).<SecurityProviderRightsEventElection.SecurityProviderRightsEventElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAutomaticSetOff()!=null) return true;
			if (getCustomElection()!=null) return true;
			if (getFullDischarge()!=null) return true;
			if (getIncludeCoolingOffLanguage()!=null) return true;
			if (getPartyElection()!=null && getPartyElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder o = (SecurityProviderRightsEvent.SecurityProviderRightsEventBuilder) other;
			
			merger.mergeRosetta(getPartyElection(), o.getPartyElection(), this::getOrCreatePartyElection);
			
			merger.mergeBasic(getAutomaticSetOff(), o.getAutomaticSetOff(), this::setAutomaticSetOff);
			merger.mergeBasic(getCustomElection(), o.getCustomElection(), this::setCustomElection);
			merger.mergeBasic(getFullDischarge(), o.getFullDischarge(), this::setFullDischarge);
			merger.mergeBasic(getIncludeCoolingOffLanguage(), o.getIncludeCoolingOffLanguage(), this::setIncludeCoolingOffLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecurityProviderRightsEvent _that = getType().cast(o);
		
			if (!Objects.equals(automaticSetOff, _that.getAutomaticSetOff())) return false;
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			if (!Objects.equals(fullDischarge, _that.getFullDischarge())) return false;
			if (!Objects.equals(includeCoolingOffLanguage, _that.getIncludeCoolingOffLanguage())) return false;
			if (!ListEquals.listEquals(partyElection, _that.getPartyElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (automaticSetOff != null ? automaticSetOff.hashCode() : 0);
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			_result = 31 * _result + (fullDischarge != null ? fullDischarge.hashCode() : 0);
			_result = 31 * _result + (includeCoolingOffLanguage != null ? includeCoolingOffLanguage.hashCode() : 0);
			_result = 31 * _result + (partyElection != null ? partyElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityProviderRightsEventBuilder {" +
				"automaticSetOff=" + this.automaticSetOff + ", " +
				"customElection=" + this.customElection + ", " +
				"fullDischarge=" + this.fullDischarge + ", " +
				"includeCoolingOffLanguage=" + this.includeCoolingOffLanguage + ", " +
				"partyElection=" + this.partyElection +
			'}';
		}
	}
}
