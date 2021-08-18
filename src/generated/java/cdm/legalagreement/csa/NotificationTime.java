package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.NotificationTimeMeta;
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
 * A class to specify the time by which a demand for the Transfer of Eligible Credit Support (IM) or Posted Credit Support (IM) needs to be made in order for the transfer to take place in accordance with the Transfer Timing provisions. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (d)(iii): Notification Time. | ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (e)(iii): Notification Time. | ISDA 2016 New York Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (d)(iii): Notification Time.
 * @version ${project.version}
 */
@RosettaClass

public interface NotificationTime extends RosettaModelObject {
	NotificationTime build();
	NotificationTime.NotificationTimeBuilder toBuilder();
	
	/**
	 * The determination of whether reference is made to dispute resolution notification timing in the agreement.
	 */
	Boolean getDisputeNotificationReference();
	/**
	 * The parties&#39; Notification Time election.
	 */
	List<? extends NotificationTimeElection> getPartyElections();
	/**
	 * The determination of whether transfer timing language is applicable or not.
	 */
	Boolean getTransferTimingProviso();
	final static NotificationTimeMeta metaData = new NotificationTimeMeta();
	
	@Override
	default RosettaMetaData<? extends NotificationTime> metaData() {
		return metaData;
	} 
			
	static NotificationTime.NotificationTimeBuilder builder() {
		return new NotificationTime.NotificationTimeBuilderImpl();
	}
	
	default Class<? extends NotificationTime> getType() {
		return NotificationTime.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("disputeNotificationReference"), Boolean.class, getDisputeNotificationReference(), this);
		processor.processBasic(path.newSubPath("transferTimingProviso"), Boolean.class, getTransferTimingProviso(), this);
		
		processRosetta(path.newSubPath("partyElections"), processor, NotificationTimeElection.class, getPartyElections());
	}
	
	
	interface NotificationTimeBuilder extends NotificationTime, RosettaModelObjectBuilder {
		NotificationTimeElection.NotificationTimeElectionBuilder getOrCreatePartyElections(int _index);
		List<? extends NotificationTimeElection.NotificationTimeElectionBuilder> getPartyElections();
		NotificationTime.NotificationTimeBuilder setDisputeNotificationReference(Boolean disputeNotificationReference);
		NotificationTime.NotificationTimeBuilder addPartyElections(NotificationTimeElection partyElections);
		NotificationTime.NotificationTimeBuilder addPartyElections(NotificationTimeElection partyElections, int _idx);
		NotificationTime.NotificationTimeBuilder addPartyElections(List<? extends NotificationTimeElection> partyElections);
		NotificationTime.NotificationTimeBuilder setPartyElections(List<? extends NotificationTimeElection> partyElections);
		NotificationTime.NotificationTimeBuilder setTransferTimingProviso(Boolean transferTimingProviso);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("disputeNotificationReference"), Boolean.class, getDisputeNotificationReference(), this);
			processor.processBasic(path.newSubPath("transferTimingProviso"), Boolean.class, getTransferTimingProviso(), this);
			
			processRosetta(path.newSubPath("partyElections"), processor, NotificationTimeElection.NotificationTimeElectionBuilder.class, getPartyElections());
		}
		
	}
	
	//NotificationTime.NotificationTimeImpl
	class NotificationTimeImpl implements NotificationTime {
		private final Boolean disputeNotificationReference;
		private final List<? extends NotificationTimeElection> partyElections;
		private final Boolean transferTimingProviso;
		
		protected NotificationTimeImpl(NotificationTime.NotificationTimeBuilder builder) {
			this.disputeNotificationReference = builder.getDisputeNotificationReference();
			this.partyElections = ofNullable(builder.getPartyElections()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.transferTimingProviso = builder.getTransferTimingProviso();
		}
		
		@Override
		public Boolean getDisputeNotificationReference() {
			return disputeNotificationReference;
		}
		
		@Override
		public List<? extends NotificationTimeElection> getPartyElections() {
			return partyElections;
		}
		
		@Override
		public Boolean getTransferTimingProviso() {
			return transferTimingProviso;
		}
		
		@Override
		public NotificationTime build() {
			return this;
		}
		
		@Override
		public NotificationTime.NotificationTimeBuilder toBuilder() {
			NotificationTime.NotificationTimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotificationTime.NotificationTimeBuilder builder) {
			ofNullable(getDisputeNotificationReference()).ifPresent(builder::setDisputeNotificationReference);
			ofNullable(getPartyElections()).ifPresent(builder::setPartyElections);
			ofNullable(getTransferTimingProviso()).ifPresent(builder::setTransferTimingProviso);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotificationTime _that = getType().cast(o);
		
			if (!Objects.equals(disputeNotificationReference, _that.getDisputeNotificationReference())) return false;
			if (!ListEquals.listEquals(partyElections, _that.getPartyElections())) return false;
			if (!Objects.equals(transferTimingProviso, _that.getTransferTimingProviso())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (disputeNotificationReference != null ? disputeNotificationReference.hashCode() : 0);
			_result = 31 * _result + (partyElections != null ? partyElections.hashCode() : 0);
			_result = 31 * _result + (transferTimingProviso != null ? transferTimingProviso.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotificationTime {" +
				"disputeNotificationReference=" + this.disputeNotificationReference + ", " +
				"partyElections=" + this.partyElections + ", " +
				"transferTimingProviso=" + this.transferTimingProviso +
			'}';
		}
	}
	
	//NotificationTime.NotificationTimeBuilderImpl
	class NotificationTimeBuilderImpl implements NotificationTime.NotificationTimeBuilder {
	
		protected Boolean disputeNotificationReference;
		protected List<NotificationTimeElection.NotificationTimeElectionBuilder> partyElections = new ArrayList<>();
		protected Boolean transferTimingProviso;
	
		public NotificationTimeBuilderImpl() {
		}
	
		@Override
		public Boolean getDisputeNotificationReference() {
			return disputeNotificationReference;
		}
		
		@Override
		public List<? extends NotificationTimeElection.NotificationTimeElectionBuilder> getPartyElections() {
			return partyElections;
		}
		
		public NotificationTimeElection.NotificationTimeElectionBuilder getOrCreatePartyElections(int _index) {
		
			if (partyElections==null) {
				this.partyElections = new ArrayList<>();
			}
			NotificationTimeElection.NotificationTimeElectionBuilder result;
			return getIndex(partyElections, _index, () -> {
						NotificationTimeElection.NotificationTimeElectionBuilder newPartyElections = NotificationTimeElection.builder();
						return newPartyElections;
					});
		}
		
		@Override
		public Boolean getTransferTimingProviso() {
			return transferTimingProviso;
		}
		
	
		@Override
		public NotificationTime.NotificationTimeBuilder setDisputeNotificationReference(Boolean disputeNotificationReference) {
			this.disputeNotificationReference = disputeNotificationReference==null?null:disputeNotificationReference;
			return this;
		}
		@Override
		public NotificationTime.NotificationTimeBuilder addPartyElections(NotificationTimeElection partyElections) {
			if (partyElections!=null) this.partyElections.add(partyElections.toBuilder());
			return this;
		}
		
		@Override
		public NotificationTime.NotificationTimeBuilder addPartyElections(NotificationTimeElection partyElections, int _idx) {
			getIndex(this.partyElections, _idx, () -> partyElections.toBuilder());
			return this;
		}
		@Override 
		public NotificationTime.NotificationTimeBuilder addPartyElections(List<? extends NotificationTimeElection> partyElectionss) {
			if (partyElectionss != null) {
				for (NotificationTimeElection toAdd : partyElectionss) {
					this.partyElections.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public NotificationTime.NotificationTimeBuilder setPartyElections(List<? extends NotificationTimeElection> partyElectionss) {
			if (partyElectionss == null)  {
				this.partyElections = new ArrayList<>();
			}
			else {
				this.partyElections = partyElectionss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public NotificationTime.NotificationTimeBuilder setTransferTimingProviso(Boolean transferTimingProviso) {
			this.transferTimingProviso = transferTimingProviso==null?null:transferTimingProviso;
			return this;
		}
		
		@Override
		public NotificationTime build() {
			return new NotificationTime.NotificationTimeImpl(this);
		}
		
		@Override
		public NotificationTime.NotificationTimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotificationTime.NotificationTimeBuilder prune() {
			partyElections = partyElections.stream().filter(b->b!=null).<NotificationTimeElection.NotificationTimeElectionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDisputeNotificationReference()!=null) return true;
			if (getPartyElections()!=null && getPartyElections().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTransferTimingProviso()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotificationTime.NotificationTimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotificationTime.NotificationTimeBuilder o = (NotificationTime.NotificationTimeBuilder) other;
			
			merger.mergeRosetta(getPartyElections(), o.getPartyElections(), this::getOrCreatePartyElections);
			
			merger.mergeBasic(getDisputeNotificationReference(), o.getDisputeNotificationReference(), this::setDisputeNotificationReference);
			merger.mergeBasic(getTransferTimingProviso(), o.getTransferTimingProviso(), this::setTransferTimingProviso);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotificationTime _that = getType().cast(o);
		
			if (!Objects.equals(disputeNotificationReference, _that.getDisputeNotificationReference())) return false;
			if (!ListEquals.listEquals(partyElections, _that.getPartyElections())) return false;
			if (!Objects.equals(transferTimingProviso, _that.getTransferTimingProviso())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (disputeNotificationReference != null ? disputeNotificationReference.hashCode() : 0);
			_result = 31 * _result + (partyElections != null ? partyElections.hashCode() : 0);
			_result = 31 * _result + (transferTimingProviso != null ? transferTimingProviso.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotificationTimeBuilder {" +
				"disputeNotificationReference=" + this.disputeNotificationReference + ", " +
				"partyElections=" + this.partyElections + ", " +
				"transferTimingProviso=" + this.transferTimingProviso +
			'}';
		}
	}
}
