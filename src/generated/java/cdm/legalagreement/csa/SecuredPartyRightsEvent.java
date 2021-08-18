package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.SecuredPartyRightsEventMeta;
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
 * A class to specify Secured Party Rights Event language
 * @version ${project.version}
 */
@RosettaClass

public interface SecuredPartyRightsEvent extends RosettaModelObject {
	SecuredPartyRightsEvent build();
	SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder toBuilder();
	
	/**
	 * A boolean attribute to specify whether Failure to Pay Early Termination language is included (True) or excluded (False) from the agreement.
	 */
	Boolean getEarlyTerminationDateOptionalLanguage();
	/**
	 * A boolean attribute to specify whether Failure to Pay Early Termination language in the agreement is deemed applicable or not.
	 */
	Boolean getFailureToPayEarlyTermination();
	/**
	 */
	List<? extends SecuredPartyRightsEventElection> getSecuredPartyRightsEventElection();
	final static SecuredPartyRightsEventMeta metaData = new SecuredPartyRightsEventMeta();
	
	@Override
	default RosettaMetaData<? extends SecuredPartyRightsEvent> metaData() {
		return metaData;
	} 
			
	static SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder builder() {
		return new SecuredPartyRightsEvent.SecuredPartyRightsEventBuilderImpl();
	}
	
	default Class<? extends SecuredPartyRightsEvent> getType() {
		return SecuredPartyRightsEvent.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("earlyTerminationDateOptionalLanguage"), Boolean.class, getEarlyTerminationDateOptionalLanguage(), this);
		processor.processBasic(path.newSubPath("failureToPayEarlyTermination"), Boolean.class, getFailureToPayEarlyTermination(), this);
		
		processRosetta(path.newSubPath("securedPartyRightsEventElection"), processor, SecuredPartyRightsEventElection.class, getSecuredPartyRightsEventElection());
	}
	
	
	interface SecuredPartyRightsEventBuilder extends SecuredPartyRightsEvent, RosettaModelObjectBuilder {
		SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder getOrCreateSecuredPartyRightsEventElection(int _index);
		List<? extends SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder> getSecuredPartyRightsEventElection();
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder setEarlyTerminationDateOptionalLanguage(Boolean earlyTerminationDateOptionalLanguage);
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder setFailureToPayEarlyTermination(Boolean failureToPayEarlyTermination);
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder addSecuredPartyRightsEventElection(SecuredPartyRightsEventElection securedPartyRightsEventElection);
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder addSecuredPartyRightsEventElection(SecuredPartyRightsEventElection securedPartyRightsEventElection, int _idx);
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder addSecuredPartyRightsEventElection(List<? extends SecuredPartyRightsEventElection> securedPartyRightsEventElection);
		SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder setSecuredPartyRightsEventElection(List<? extends SecuredPartyRightsEventElection> securedPartyRightsEventElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("earlyTerminationDateOptionalLanguage"), Boolean.class, getEarlyTerminationDateOptionalLanguage(), this);
			processor.processBasic(path.newSubPath("failureToPayEarlyTermination"), Boolean.class, getFailureToPayEarlyTermination(), this);
			
			processRosetta(path.newSubPath("securedPartyRightsEventElection"), processor, SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder.class, getSecuredPartyRightsEventElection());
		}
		
	}
	
	//SecuredPartyRightsEvent.SecuredPartyRightsEventImpl
	class SecuredPartyRightsEventImpl implements SecuredPartyRightsEvent {
		private final Boolean earlyTerminationDateOptionalLanguage;
		private final Boolean failureToPayEarlyTermination;
		private final List<? extends SecuredPartyRightsEventElection> securedPartyRightsEventElection;
		
		protected SecuredPartyRightsEventImpl(SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder builder) {
			this.earlyTerminationDateOptionalLanguage = builder.getEarlyTerminationDateOptionalLanguage();
			this.failureToPayEarlyTermination = builder.getFailureToPayEarlyTermination();
			this.securedPartyRightsEventElection = ofNullable(builder.getSecuredPartyRightsEventElection()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public Boolean getEarlyTerminationDateOptionalLanguage() {
			return earlyTerminationDateOptionalLanguage;
		}
		
		@Override
		public Boolean getFailureToPayEarlyTermination() {
			return failureToPayEarlyTermination;
		}
		
		@Override
		public List<? extends SecuredPartyRightsEventElection> getSecuredPartyRightsEventElection() {
			return securedPartyRightsEventElection;
		}
		
		@Override
		public SecuredPartyRightsEvent build() {
			return this;
		}
		
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder toBuilder() {
			SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder builder) {
			ofNullable(getEarlyTerminationDateOptionalLanguage()).ifPresent(builder::setEarlyTerminationDateOptionalLanguage);
			ofNullable(getFailureToPayEarlyTermination()).ifPresent(builder::setFailureToPayEarlyTermination);
			ofNullable(getSecuredPartyRightsEventElection()).ifPresent(builder::setSecuredPartyRightsEventElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuredPartyRightsEvent _that = getType().cast(o);
		
			if (!Objects.equals(earlyTerminationDateOptionalLanguage, _that.getEarlyTerminationDateOptionalLanguage())) return false;
			if (!Objects.equals(failureToPayEarlyTermination, _that.getFailureToPayEarlyTermination())) return false;
			if (!ListEquals.listEquals(securedPartyRightsEventElection, _that.getSecuredPartyRightsEventElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (earlyTerminationDateOptionalLanguage != null ? earlyTerminationDateOptionalLanguage.hashCode() : 0);
			_result = 31 * _result + (failureToPayEarlyTermination != null ? failureToPayEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (securedPartyRightsEventElection != null ? securedPartyRightsEventElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuredPartyRightsEvent {" +
				"earlyTerminationDateOptionalLanguage=" + this.earlyTerminationDateOptionalLanguage + ", " +
				"failureToPayEarlyTermination=" + this.failureToPayEarlyTermination + ", " +
				"securedPartyRightsEventElection=" + this.securedPartyRightsEventElection +
			'}';
		}
	}
	
	//SecuredPartyRightsEvent.SecuredPartyRightsEventBuilderImpl
	class SecuredPartyRightsEventBuilderImpl implements SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder {
	
		protected Boolean earlyTerminationDateOptionalLanguage;
		protected Boolean failureToPayEarlyTermination;
		protected List<SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder> securedPartyRightsEventElection = new ArrayList<>();
	
		public SecuredPartyRightsEventBuilderImpl() {
		}
	
		@Override
		public Boolean getEarlyTerminationDateOptionalLanguage() {
			return earlyTerminationDateOptionalLanguage;
		}
		
		@Override
		public Boolean getFailureToPayEarlyTermination() {
			return failureToPayEarlyTermination;
		}
		
		@Override
		public List<? extends SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder> getSecuredPartyRightsEventElection() {
			return securedPartyRightsEventElection;
		}
		
		public SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder getOrCreateSecuredPartyRightsEventElection(int _index) {
		
			if (securedPartyRightsEventElection==null) {
				this.securedPartyRightsEventElection = new ArrayList<>();
			}
			SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder result;
			return getIndex(securedPartyRightsEventElection, _index, () -> {
						SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder newSecuredPartyRightsEventElection = SecuredPartyRightsEventElection.builder();
						return newSecuredPartyRightsEventElection;
					});
		}
		
	
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder setEarlyTerminationDateOptionalLanguage(Boolean earlyTerminationDateOptionalLanguage) {
			this.earlyTerminationDateOptionalLanguage = earlyTerminationDateOptionalLanguage==null?null:earlyTerminationDateOptionalLanguage;
			return this;
		}
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder setFailureToPayEarlyTermination(Boolean failureToPayEarlyTermination) {
			this.failureToPayEarlyTermination = failureToPayEarlyTermination==null?null:failureToPayEarlyTermination;
			return this;
		}
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder addSecuredPartyRightsEventElection(SecuredPartyRightsEventElection securedPartyRightsEventElection) {
			if (securedPartyRightsEventElection!=null) this.securedPartyRightsEventElection.add(securedPartyRightsEventElection.toBuilder());
			return this;
		}
		
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder addSecuredPartyRightsEventElection(SecuredPartyRightsEventElection securedPartyRightsEventElection, int _idx) {
			getIndex(this.securedPartyRightsEventElection, _idx, () -> securedPartyRightsEventElection.toBuilder());
			return this;
		}
		@Override 
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder addSecuredPartyRightsEventElection(List<? extends SecuredPartyRightsEventElection> securedPartyRightsEventElections) {
			if (securedPartyRightsEventElections != null) {
				for (SecuredPartyRightsEventElection toAdd : securedPartyRightsEventElections) {
					this.securedPartyRightsEventElection.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder setSecuredPartyRightsEventElection(List<? extends SecuredPartyRightsEventElection> securedPartyRightsEventElections) {
			if (securedPartyRightsEventElections == null)  {
				this.securedPartyRightsEventElection = new ArrayList<>();
			}
			else {
				this.securedPartyRightsEventElection = securedPartyRightsEventElections.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public SecuredPartyRightsEvent build() {
			return new SecuredPartyRightsEvent.SecuredPartyRightsEventImpl(this);
		}
		
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder prune() {
			securedPartyRightsEventElection = securedPartyRightsEventElection.stream().filter(b->b!=null).<SecuredPartyRightsEventElection.SecuredPartyRightsEventElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEarlyTerminationDateOptionalLanguage()!=null) return true;
			if (getFailureToPayEarlyTermination()!=null) return true;
			if (getSecuredPartyRightsEventElection()!=null && getSecuredPartyRightsEventElection().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder o = (SecuredPartyRightsEvent.SecuredPartyRightsEventBuilder) other;
			
			merger.mergeRosetta(getSecuredPartyRightsEventElection(), o.getSecuredPartyRightsEventElection(), this::getOrCreateSecuredPartyRightsEventElection);
			
			merger.mergeBasic(getEarlyTerminationDateOptionalLanguage(), o.getEarlyTerminationDateOptionalLanguage(), this::setEarlyTerminationDateOptionalLanguage);
			merger.mergeBasic(getFailureToPayEarlyTermination(), o.getFailureToPayEarlyTermination(), this::setFailureToPayEarlyTermination);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SecuredPartyRightsEvent _that = getType().cast(o);
		
			if (!Objects.equals(earlyTerminationDateOptionalLanguage, _that.getEarlyTerminationDateOptionalLanguage())) return false;
			if (!Objects.equals(failureToPayEarlyTermination, _that.getFailureToPayEarlyTermination())) return false;
			if (!ListEquals.listEquals(securedPartyRightsEventElection, _that.getSecuredPartyRightsEventElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (earlyTerminationDateOptionalLanguage != null ? earlyTerminationDateOptionalLanguage.hashCode() : 0);
			_result = 31 * _result + (failureToPayEarlyTermination != null ? failureToPayEarlyTermination.hashCode() : 0);
			_result = 31 * _result + (securedPartyRightsEventElection != null ? securedPartyRightsEventElection.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecuredPartyRightsEventBuilder {" +
				"earlyTerminationDateOptionalLanguage=" + this.earlyTerminationDateOptionalLanguage + ", " +
				"failureToPayEarlyTermination=" + this.failureToPayEarlyTermination + ", " +
				"securedPartyRightsEventElection=" + this.securedPartyRightsEventElection +
			'}';
		}
	}
}
